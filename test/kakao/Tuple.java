package kakao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tuple {

    /*셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다.
    n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.

    (a1, a2, a3, ..., an)
    */

    /*튜플은 다음과 같은 성질을 가지고 있습니다.

    중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
    원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
    튜플의 원소 개수는 유한합니다.
    원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수),
    이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.

    {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}*/

    /*예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

    {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
    와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

    {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
    {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
    {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
    는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.*/

    /*특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때,
    s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.*/


    // 주어진 문자열에서 숫자만을 찾아내는 정규식
    Pattern pattern = Pattern.compile("[0-9]+");

    @ParameterizedTest
    @ValueSource(strings = {
            "{{2},{2,1},{2,1,3},{2,1,3,4}}",
            "{{1,2,3},{2,1},{1,2,4,3},{2}}",
            "{{4,2,3},{3},{2,3,4,1},{2,3}}",
            "{{20,111},{111}}"
    })
    @DisplayName("튜플")
    void tuple(String s){
        Map<Integer, Integer> map = new HashMap<>();
        Matcher m = pattern.matcher(s);

        // 문자열에서 정규식의 패턴에 일치할 시 true를 리턴하고 그 위치로 계속 이동
        while(m.find()){
            int start = m.start(); // 패턴이 일치하는 문자열의 시작 위치
            int end = m.end();  // 패턴이 일치하는 문자열 다음의 위치

            // 문자열 추출
            int key = Integer.parseInt(s.substring(start, end));
            // 문자열의 개수를 세어줌
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int[] answer = new int[map.size()];

        // 문자열의 개수가 많은 요소부터 내림차순 정렬
        int idx = 0;
        while(!map.isEmpty()){
            int max = 0;
            int maxKey = 0;
            for(int key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    maxKey = key;
                }
            }
            answer[idx] = maxKey;
            map.remove(maxKey);
            idx++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
