package begginer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveDuplicateStrings {

    /**
     * 중복된 문자 제거
     * https://school.programmers.co.kr/learn/courses/30/lessons/120888
     */
    /*문제 설명
    문자열 my_string이 매개변수로 주어집니다. my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ my_string ≤ 110
    my_string은 대문자, 소문자, 공백으로 구성되어 있습니다.
    대문자와 소문자를 구분합니다.
    공백(" ")도 하나의 문자로 구분합니다.
    중복된 문자 중 가장 앞에 있는 문자를 남깁니다.*/

    @ParameterizedTest
    @ValueSource(strings = {"people", "We are the world"})
    void removeDuplicateStrings(String my_string){
        String answer = "";
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] sarr = my_string.split("");
        for(String str : sarr){
            map.put(str, map.getOrDefault(str, 0) +1);
            if(map.get(str) != null && map.get(str) > 1){
                continue;
            }
            answer += str;
        }
        System.out.println(answer);
    }

    //stream 활용(다른 사람 풀이)
    @ParameterizedTest
    @ValueSource(strings = {"people", "We are the world"})
    void removeDuplicateStrings2(String my_string){
        String answer = my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
        System.out.println(answer);
    }

    //indexOf 활용(다른 사람 풀이)
    @ParameterizedTest
    @ValueSource(strings = {"people", "We are the world"})
    void removeDuplicateStrings3(String my_string){
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            if(i==my_string.indexOf(my_string.charAt(i)))
                answer+=my_string.charAt(i);
        }
        System.out.println(answer);
    }
}
