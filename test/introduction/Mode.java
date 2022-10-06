package introduction;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Mode {

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
