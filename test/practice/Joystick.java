package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Joystick {
    /*문제 설명
    조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
    ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

    조이스틱을 각 방향으로 움직이면 아래와 같습니다.

    ▲ - 다음 알파벳
    ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
    ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
    ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
    예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

    - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
    - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
    - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
    따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
    만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

    제한 사항
    name은 알파벳 대문자로만 이루어져 있습니다.
    name의 길이는 1 이상 20 이하입니다.*/

    /**
     * 문제 해결을 위한 고려 사항
     * 1) 좌우이동
     *   - 처음부터 쭉 오른쪽으로 간 경우
     *   - 오른쪽으로 갔다가 다시 왼쪽으로 가는 경우
     *   - 왼쪽으로 갔다가 다시 오른쪽으로 가는 경우
     */

    int answer = 0;

    void getChangeCount(char[] charArr){
        for(int i = 0; i < charArr.length; i++){
            int toInt = (int)charArr[i];
            int cost = Math.min(Math.abs(65 - toInt), Math.abs(91 - toInt));
            answer += cost;
        }
    }

    int getMoveCount(char[] charArr){
        //오른쪽으로 쭉 갔을 때의 이동 횟수
        int move = charArr.length - 1;
        for(int i = 0; i < charArr.length; i++){
            //다음 알파벳이 A인 경우 이어져있는지 확인
            if(i < charArr.length - 1 && charArr[i+1] == 'A'){
                int end = i+1;
                while(end < charArr.length && charArr[end] == 'A') {
                    end++;
                }
                move = Math.min(move, i*2 + (charArr.length - end));
                move = Math.min(move, (charArr.length - end)*2 + i);
            }
        }
        return move;
    }

    @ParameterizedTest
    @ValueSource(strings = { "JEROEN","JAN","PIZAAABAAPO"})
    void joystick(String name){
        char[] charArray = name.toCharArray();
        //각 문자열의 위*아래 조이스틱 가동 횟수 구하기
        getChangeCount(charArray);
        //좌*우 이동 횟수 구하기
        int move = getMoveCount(charArray);
        System.out.println(answer + move);

    }
}
