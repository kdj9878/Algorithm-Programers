package practice.lv3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TheLongJump {

    /**
     *  멀리 뛰기
     *  https://school.programmers.co.kr/learn/courses/30/lessons/12914
     */

    /*문제 설명
    효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
    (1칸, 1칸, 1칸, 1칸)
    (1칸, 2칸, 1칸)
    (1칸, 1칸, 2칸)
    (2칸, 1칸, 1칸)
    (2칸, 2칸)
    의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
    멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
    예를 들어 4가 입력된다면, 5를 return하면 됩니다.*/

    /*제한 사항
    n은 1 이상, 2000 이하인 정수입니다*/


    @ParameterizedTest
    @ValueSource(ints = {2000, 3})
    void theLongJump(int n){
        long answer = 0;
        if(n == 1) System.out.println(1);
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }

        System.out.println(dp[n]);
    }
}
