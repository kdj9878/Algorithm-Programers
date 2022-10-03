package kakaoTeckInternship;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PersonalityType {

    /*문제 설명
    나만의 카카오 성격 유형 검사지를 만들려고 합니다.
    성격 유형 검사는 다음과 같은 4개 지표로 성격 유형을 구분합니다. 성격은 각 지표에서 두 유형 중 하나로 결정됩니다.*/

    String[] servies = {"T", "R", "C", "F", "J", "M", "A", "N"};
    String[] wholeServies = {"RT", "FC", "MJ", "AN"};
    Map<Character, Integer> map = new HashMap<>();
    void init(String[] servies){
        for(int i = 0; i < servies.length; i++) map.put(servies[i].charAt(0), 0);
    }

    @Test
    void personalityType(){
        String[] servey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        String answer = "";
        init(servies);
        for(int i = 0; i < servey.length; i++){
            char first = servey[i].substring(0, 1).charAt(0);
            char second = servey[i].substring(1, 2).charAt(0);
            if(choices[i] < 4){
                map.put(first, map.get(first) + (4 - choices[i]));
            }
            else if(choices[i] > 4){
                map.put(second, map.get(second) + (choices[i] - 4));
            }
        }

        for(int i = 0; i < wholeServies.length; i++){
            char first = wholeServies[i].substring(0, 1).charAt(0);
            char second = wholeServies[i].substring(1, 2).charAt(0);
            int firstValue = map.get(first);
            int secondValue = map.get(second);
            if(firstValue == secondValue){
                int toAscii1 = (int)first;
                int toAscii2 = (int)second;
                answer += toAscii1 < toAscii2 ? first : second;
            } else if(firstValue > secondValue){
                answer += first;
            } else{
                answer += second;
            }
        }

        System.out.println(answer);
    }
}
