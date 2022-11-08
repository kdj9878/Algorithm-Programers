package practice;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class DivideOfCaseWithBead {
    /*문제 설명
    머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다.
    머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

    제한사항
    1 ≤ balls ≤ 30
    1 ≤ share ≤ 30
    구슬을 고르는 순서는 고려하지 않습니다.
    share ≤ balls*/

    int balls = 28;
    int share = 12;

    @Test
    void divideOfCaseWithBead(){
        BigInteger n = BigInteger.ONE;
        BigInteger m = BigInteger.ONE;
        // nCr = n! / (n-r)! * r!
        long s1 = balls - share;
        long s2 = share;

        // n-r보다 큰 n * (n-1) * (n-2) ...
        //만약 5C2라면 5!/(5-2)! * 2!
        //ex. 5! => 5 x 4 x 3 x 2 x 1 / (5-2)! => 3 x 2 x 1 에서 중복되는 3 x 2 x 1을 제외한 5 x 4만 계산
        for(long i = s1+1; i <= balls; i++){
            n = n.multiply(BigInteger.valueOf(i));
        }

        //nCr에서 r에 해당하는 부분
        for(long j = 2L; j <= s2; j++){
            m = m.multiply(BigInteger.valueOf(j));
        }

        System.out.println(n.divide(m));
    }
}
