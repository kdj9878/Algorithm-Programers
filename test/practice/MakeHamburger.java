package practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MakeHamburger {

    private Node[] nodeArr;
    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> temp = new LinkedList<>();

    private boolean isFirst = false;

    int[] ingredient = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};

    class Node{
        int idx;
        String val;

        Node(int idx, String val){
            this.idx = idx;
            this.val = val;
        }

        void changeIdx(){
            this.idx -= 4;
        }
    }

    void init(int[] ingredient){
        nodeArr = new Node[ingredient.length];
        for(int i = 0; i < ingredient.length; i++){
            nodeArr[i] = new Node(i, String.valueOf(ingredient[i]));
        }
    }

    /**
     * 테스트케이스는 통과, 제출은 실패 3 ~ 12
     */
    @Test
    void makeHamburger(){
        int answer = 0;
        init(ingredient);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nodeArr.length; i++){
            boolean check = false;
            Node node = nodeArr[i];
            String nodeVal = node.val;
            sb.append(nodeVal);

            //1의 위치를 저장
            if(nodeVal.equals("1")) {
                Object preIdx = queue.peek();
                if(preIdx != null){
                    check = (node.idx - (int)preIdx) == 3 ? true : false;
                }
                queue.add(node.idx);
            }

            if(sb.length() > 3 && !queue.isEmpty()){
                if(check && sb.substring(queue.peek(), queue.peek() + 4).equals("1231")){
                    int removeIdx = queue.poll();
                    int changeStartIdx = queue.poll()+1;
                    sb.replace(removeIdx, removeIdx+4, "");
                    answer++;
                    //StringBuilder에서 replace가 발생했을 경우 삭제된 문자열 뒤에 노드들의 idx를 변경해준다.
                    if(i == nodeArr.length){
                        break;
                    }
                    for(int j = changeStartIdx; j < nodeArr.length; j++){
                        nodeArr[j].changeIdx();
                    }
                    while(!temp.isEmpty()){
                        queue.add(temp.poll());
                    }
                    continue;
                }
                else if(!isFirst && temp.isEmpty()){
                    temp.add(queue.poll());
                    isFirst = true;
                }
                else if((queue.peek() + 4 <= sb.length()) || (queue.peek() == 0 && sb.charAt(0) == '1')){
                    temp.add(queue.poll());
                }
            }
        }
        System.out.println(answer);
    }

    /**
     * 처음 제출한 코드, 테스트케이스는 통과하지만 제출은 시간초과 4 ~ 9, 12
     */
    @Test
    void makeHamburger2(){
        int answer = 0;
        //공백 및 쓸데없는 문자열 제거
        String str = Arrays.toString(ingredient).replaceAll("\\,|\\[|\\]|\\s", "");
        boolean state = true;

        while(state){
            if(str.indexOf("1231") > -1){
                str = str.replaceFirst("1231", "");
                answer++;
            }
            else{
                state = false;
            }
        }
        System.out.println(answer);
    }

    /**
     * 테스트케이스 성공, 제출 실패....
     * 4~9, 12 시간초과
     */
    @Test
    void makeHamburger3(){
        int answer = 0;
        String str = Arrays.toString(ingredient).replaceAll("\\,|\\[|\\]|\\s", "");
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < str.length(); i++){
            if(i+4 > sb.length()){
                break;
            }
            String temp = sb.substring(i, i+4);
            if(temp.equals("1231")){
                answer++;
                sb.replace(i, i+4, "");
                i -= (i+1);
            }
        }
        System.out.println(answer);
    }

    private static void packaging_Burger(Stack<Integer> ingredients) {
        ingredients.pop();
        ingredients.pop();
        ingredients.pop();
        ingredients.pop();
    }

    /**
     * Stack활용..참고한 코드 쉽게 생각하면 되는건데...
     */
    @Test
    void makeHamburger4(){
        int answer = 0;
        Stack<Integer> ingredients = new Stack<>();
        for (int num = 0; num < ingredient.length; num++) {
            ingredients.push(ingredient[num]);
            int size = ingredients.size();
            if (size > 3 && ingredients.peek() == 1
                    && ingredients.get(size-2) == 3
                    && ingredients.get(size-3) == 2
                    && ingredients.get(size-4) == 1) {
                packaging_Burger(ingredients);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
