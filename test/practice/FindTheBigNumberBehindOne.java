package practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class FindTheBigNumberBehindOne {

    /*문제 설명
    정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
    정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

    제한사항
    4 ≤ numbers의 길이 ≤ 1,000,000
    1 ≤ numbers[i] ≤ 1,000,000*/

    int[] numbers = {9, 1, 5, 3, 6, 2};

    int[] answer;

    void init(int len){
        answer = new int[len];
        for(int i = 0; i < len; i++){
            answer[i] = -1;
        }
    }

    /**
     * 처음 제출 코드
     * 테스트케이스 20, 21, 22, 23 시간 초과
     */
    @Test
    void findTheBigNumberBehindOne(){
        init(numbers.length);
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }

    /**
     * PriorityQueue를 이요한 풀이
     * 다른 사람 풀이
     */
    @Test
    void findTheBigNumberBehindOneByPQ(){
        // [ index, value ] 배열을 value 오름차순으로 담는 prioriryQueue선언
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int index = 0; index < numbers.length; index++) {

            int value = numbers[index];

            // 현재 index보다 앞에 있는 index 중
            // 현재 value보다 작은값을 가지는 index를 현재 value로 치환
            while (!queue.isEmpty() && queue.peek()[1] < value)
                numbers[queue.poll()[0]] = value;

            queue.add(new int[] { index, value });
        }

        // 미처리 index에 -1 대입
        while (!queue.isEmpty())
            numbers[queue.poll()[0]] = -1;

        System.out.println(Arrays.toString(numbers));
    }

    /**
     * Stack을 활용한 코드
     * 효율성이나 코드 이해에 있어서 우선순위큐보다는 Stack이 좋을 듯
     */
    @Test
    void findTheBigNumberBehindOneByStack(){
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < numbers.length; i++){
            int val = numbers[i];
            while(!stack.isEmpty() && stack.peek()[1] < val){
                numbers[stack.pop()[0]] = val;
            }
            stack.add(new int[]{i, val});
        }
        while(!stack.isEmpty()){
            numbers[stack.pop()[0]] = -1;
        }
        System.out.println(Arrays.toString(numbers));
    }
}
