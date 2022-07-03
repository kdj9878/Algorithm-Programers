package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NLeastCommonMultiple {

    /*문제 설명
    두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
    예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
    n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.*/

    /*제한 사항
    arr은 길이 1이상, 15이하인 배열입니다.
    arr의 원소는 100 이하인 자연수입니다.*/

    /* 문제 해결 포인트
    n개의 숫자들을 소인수 분해를 하였을 때 존재하는 모든 밑과 지수를 구하고
    해당 밑들 중에서 가장 큰 지수를 가진 요소들만 추출
    그 후에 필터링한 밑과 지수들을 곱해주면 n개의 숫자들의 최소공배수가 나옴
     */

    // 밑/지수에 관한 정보를 담고있는 ArrayList
    ArrayList<Map<Integer, Integer>> factorList = new ArrayList<>();

    // 어떠한 밑이 있는지 전부 저장
    Map<Integer, Integer> factorMap = new HashMap<>();

    // 소인수분해해서 그 결과값을 ArrayList에 담기
    public void factorization(int n){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 2; i <= n; i++){
            while(n%i == 0){
                map.put(i, map.getOrDefault(i, 0) + 1);
                factorMap.put(i, 0);
                n = n/i;
            }
        }
        factorList.add(map);
    }

    @Test
    @DisplayName("N개의 최소공배수")
    void NLeastCommonMultiple(){
        int[] arr = {2,6,8,14};

        int answer = 1;

        for(int i = 0; i < arr.length; i++) {
            factorization(arr[i]);
        }

        // (가지고 있는 밑, 가장 큰 지수)의 정보를 factorMap에 세팅
        for(Map<Integer, Integer> map : factorList){
            for(int factor : map.keySet()){
                int base = map.get(factor);
                if(factorMap.get(factor) < base){
                    factorMap.put(factor, base);
                }
            }
        }

        // 전부 곱해주기
        for(int key : factorMap.keySet()){
            int value = factorMap.get(key);
            answer *= Math.pow(key, value);
        }

        System.out.println(answer);
    }
}
