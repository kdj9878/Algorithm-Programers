package introduction;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Mode {

    /*문제 설명
    최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

    제한사항
    0 < array의 길이 < 100
    -1000 < array의 원소 < 1000*/

    int[] array = {1,1,1,1,1,1,1, 2};

    @Test
    void getMode(){
        int answer = 0;
        if(array.length == 1){
            System.out.println(1);
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        int maxKey = -1001;
        int maxValue = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxValue && entry.getKey() != maxKey){
                maxKey = entry.getKey();
                maxValue = entry.getValue();
                answer = maxKey;
            }
            else if(entry.getValue() == maxValue && entry.getKey() != maxKey){
                answer = -1;
            }
        }
        System.out.println(answer);
    }
}
