package practice;

import org.junit.jupiter.api.Test;

public class AlienDictionary {
    /*문제 설명
    PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다. 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다. spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.

            제한사항
    spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
    2 ≤ spell의 크기 ≤ 10
    spell의 원소의 길이는 1입니다.
    1 ≤ dic의 크기 ≤ 10
    1 ≤ dic의 원소의 길이 ≤ 10
    spell의 원소를 모두 사용해 단어를 만들어야 합니다.
    spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
    dic과 spell 모두 중복된 원소를 갖지 않습니다.*/

    String[] spell = {"p", "o", "s"};
    String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};

    @Test
    void AlienDictionary(){
        int answer = 2;
        boolean breakFlag = false;
        int spellLen = spell.length;
        for(String dicSp : dic){
            int dicLen = dicSp.length();
            int ansLen = dicLen - spellLen;
            for(String sp : spell){
                dicSp = dicSp.replaceFirst(sp, "");
            }
            if(ansLen == dicSp.length()){
                answer = 1;
                breakFlag = true;
            }
            if(breakFlag) break;
        }
        System.out.println(answer);
    }
}
