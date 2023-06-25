package practice.sumOfSequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumOfSequence {

    @Test
    void sumOfSequence_testCase_1(){
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        Assertions.assertArrayEquals(new int[]{2, 3}, sumOfSequence_useTwoPointAlgo(sequence, k));
    }

    @Test
    void sumOfSequence_testCase_2(){
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        sumOfSequence_useTwoPointAlgo(sequence, k);
        Assertions.assertArrayEquals(new int[]{6, 6}, sumOfSequence_useTwoPointAlgo(sequence, k));
    }

    @Test
    void sumOfSequence_testCase_3(){
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        sumOfSequence_useTwoPointAlgo(sequence, k);
        Assertions.assertArrayEquals(new int[]{0, 2}, sumOfSequence_useTwoPointAlgo(sequence, k));
    }

    /**
     * 투포인트 알고리즘을 사용하지 않은 해결(시간 초과)
     * 시간복잡도 : O(n*2)
     * @param sequence
     * @param k
     * @return
     */
    int[] sumOfSequence_badProblem(int[] sequence, int k){
        int[] answer = new int[2];
        Map<Integer, int[]> indexMap = new HashMap<>();

        for(int i = 0; i < sequence.length; i++){
            int sum = 0;
            int start = i;
            for(int j = i; j < sequence.length; j++){
                sum += sequence[j];
                if(sum == k){
                    int length = j - start;
                    if(indexMap.get(length) != null && indexMap.get(length)[0] < start){
                        break;
                    }
                    indexMap.put(j - start, new int[]{start, start, j});
                    break;
                }
                else if(sum > k){
                    break;
                }
            }
        }

        int minLength = Integer.MAX_VALUE;
        for(int p : indexMap.keySet()){
            if(minLength > p){
                minLength = p;
            }
        }

        answer[0] = indexMap.get(minLength)[1];
        answer[1] = indexMap.get(minLength)[2];

        return answer;
    }

    /**
     * 투포인터 알고리즘 사용 풀이
     * 시간복잡도 : O(n)
     * @return
     */
    int[] sumOfSequence_useTwoPointAlgo(int[] sequence, int k){
        int[] answer = new int[2];
        Map<Integer, int[]> indexMap = new HashMap<>();

        int start = 0;
        int end = 0;
        int sum = 0;
        while(start < sequence.length){
            if(sum > k || end == sequence.length){
                sum -= sequence[start++];
            }
            else {
                sum += sequence[end++];
            }
            if(sum == k){
                System.out.println("일치");
                System.out.println("start : " + start);
                System.out.println("end : " + (end - 1));
                int length = (end - 1) - start;
                if(indexMap.get(length) != null && indexMap.get(length)[0] < start){
                    continue;
                }
                indexMap.put(length, new int[]{start, start, end-1});

            }
        }

        int minLength = Integer.MAX_VALUE;
        for(int length : indexMap.keySet()){
            if(minLength > length){
                minLength = length;
            }
        }

        int[] tempArr = indexMap.get(minLength);
        answer[0] = tempArr[1];
        answer[1] = tempArr[2];
        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
