package codeChallenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.Queue;

public class TernaryReverse {

    /*자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.*/

    /*제한사항
    n은 1 이상 100,000,000 이하인 자연수입니다.*/

    public static Queue<Character> queue = new LinkedList<>();

    @ParameterizedTest
    @ValueSource(ints = {45, 125})
    @DisplayName("3진법 뒤집기")
    void ternaryReverse(int n){
        int answer = 0;

        // 주어진 숫자를 3진법으로 변환, if(n == 45) ternary = 1200
        String ternary = Integer.toString(n, 3);

        // 숫자 하나씩 넣기 위해 charArray로 변경 후 queue에 넣기
        char[] ternaryArr = ternary.toCharArray();
        for(int i = 0; i < ternaryArr.length; i++){
            queue.add(ternaryArr[i]);
        }

        // 1200을 뒤집을 경우 0021
        // 10진법 변환을 위해서 1의 자리 숫자부터 계산
        int idx = 0;
        while(!queue.isEmpty()){
            int num = Integer.parseInt(queue.poll().toString());
            if(idx == 0) {
                answer += num * 1;
            }
            else{
                answer += num * Math.pow(3, idx);
            }
            idx++;
        }

        System.out.println("answer => " + answer);
    }
}
