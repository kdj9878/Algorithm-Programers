package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SecretCode {
    /*문제 설명
    두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.

    문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
    index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
    skip에 있는 알파벳은 제외하고 건너뜁니다.
    예를 들어 s = "aukks", skip = "wbqd", index = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다.
    따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.

    두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.

    제한사항
    5 ≤ s의 길이 ≤ 50
    1 ≤ skip의 길이 ≤ 10
    s와 skip은 알파벳 소문자로만 이루어져 있습니다.
    skip에 포함되는 알파벳은 s에 포함되지 않습니다.
    1 ≤ index ≤ 20*/

    String s = "aukks";
    String skip = "wbqd";
    int index = 5;
    String answer = "happy";

    List<Integer> skipList = new ArrayList<>();

    private int checkNumberOver(int index){
        if(index > 122){
            index -= 26;
        }
        return index;
    }

    //skip의 문자열을 ascii 코드 10진수로 변환하여 리스트 저장
    private void init(String skip){
        for(int i = 0; i < skip.length(); i++){
            skipList.add((int)skip.charAt(i));
        }
    }

    private int findSkipedIndex(int start, int index){
        int cnt = 0;
        int returnIndex = start;

        //index만큼 패스
        while(cnt != index){
            returnIndex = checkNumberOver(returnIndex+1);
            boolean skip = false;
            //해당 문자열이 skip에 포함되어있을 경우 스킵
            if(skipList.contains(returnIndex)){
                skip = true;
            }

            if(!skip){
                cnt++;
            }
        }

        //index만큼 패스한 문자열도 skip에 포함될 경우 패스
        while(skipList.contains(returnIndex)){
            returnIndex = checkNumberOver(returnIndex+1);
        }

        return returnIndex;
    }

    /**
     * 내 풀이
     */
    @Test
    void secretCode(){
        String answer = "";
        init(skip);

        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i, i+1);
            int start = (int)s.charAt(i);
            int skipedIndex = findSkipedIndex(start, index);

            answer += String.valueOf((char)skipedIndex);

        }
        Assertions.assertEquals(answer, answer);
    }

    /**
     * 다른 사람 풀이
     */
    void secretCodeAnother(){
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        Assertions.assertEquals(answer, answer.toString());
    }

}
