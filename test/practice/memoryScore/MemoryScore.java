package practice.memoryScore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MemoryScore {
    Map<String, Integer> yearningMap;

    void init(String[] name, int[] yearning){
        yearningMap = new HashMap<>();
        int i = 0;
        for(String nm : name){
            yearningMap.put(nm, yearning[i]);
            i++;
        }
    }

    int countYearning(String[] photo){
        int sum = 0;
        for(int i = 0; i < photo.length; i++){
            if(yearningMap.get(photo[i]) != null){
                sum += yearningMap.get(photo[i]);
            }
        }
        return sum;
    }

    @Test
    void memoryScoreCase1(){
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = new int[photo.length];
        init(name, yearning);
        for(int i = 0; i < photo.length; i++){
            answer[i] = countYearning(photo[i]);
        }

        Assertions.assertArrayEquals(new int[]{19, 15, 6}, answer);
    }

    @Test
    void memoryScoreCase2(){
        String[] name = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photo = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};

        int[] answer = new int[photo.length];
        init(name, yearning);
        for(int i = 0; i < photo.length; i++){
            answer[i] = countYearning(photo[i]);
        }

        Assertions.assertArrayEquals(new int[]{67, 0, 55}, answer);
    }

    @Test
    void memoryScoreCase3(){
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};

        int[] answer = new int[photo.length];
        init(name, yearning);
        for(int i = 0; i < photo.length; i++){
            answer[i] = countYearning(photo[i]);
        }

        Assertions.assertArrayEquals(new int[]{5, 15, 0}, answer);
    }
}
