package practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlyOneCharacter {

    /*문제 설명
    문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.

    제한사항
    0 < s의 길이 < 1,000
    s는 소문자로만 이루어져 있습니다.*/

    @ParameterizedTest
    @ValueSource(strings = {"abcabcadc", "abdc", "hello"})
    void onlyOneCharacter(String s){
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i, i+1);
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                answer.append(entry.getKey());
            }
        }

        char[] chaArr = answer.toString().toCharArray();
        Arrays.sort(chaArr);
        answer = new StringBuilder(String.valueOf(chaArr));

        System.out.println(answer);
    }
}
