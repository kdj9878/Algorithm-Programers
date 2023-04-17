package hash.ponkemon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Ponkemon {

    int getPonkemonCount(int[] nums){
        int answer = 0;
        // nums.length/2 가질 수 있는 최대 포켓몬의 수, 항상 짝수
        Set<Integer> set = new HashSet<>();

        // 중복 제거
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int count = 0;  // 총 폰켓몬 종류
        for(int value : set){
            count++;
        }

        // 폰켓몬의 종류가 고를 수 있는 폰켓몬 수보다 클 경우 answer는 nums/length, 아닐 경우 폰켓몬의 최대 종류 수
        answer = count > nums.length/2 ? nums.length/2 : count;

        return answer;
    }

    @Test
    void testCase1(){
        int[] nums = {3,1,2,3};
        int answer = getPonkemonCount(nums);
        Assertions.assertEquals(2, answer);
    }

    @Test
    void testCase2(){
        int[] nums = {3,3,3,2,2,4};
        int answer = getPonkemonCount(nums);
        Assertions.assertEquals(3, answer);
    }

    @Test
    void testCase3(){
        int[] nums = {3,3,3,2,2,2};
        int answer = getPonkemonCount(nums);
        Assertions.assertEquals(2, answer);
    }
}
