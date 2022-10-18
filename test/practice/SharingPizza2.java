package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SharingPizza2 {
    /*문제 설명
    머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때,
    n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.*/

    @ParameterizedTest
    @ValueSource(ints = {6,10,20})
    void sharingPizaa2(int n){
        int answer = 0;
        int big = 0;
        int less = 0;
        if(n > 6){
            big = n;
            less = 6;
        }
        else{
            big = 6;
            less = n;
        }
        int gcd = GCD(big, less);
        int lcm = LCM(n*6, gcd);

        System.out.println(lcm/6);
        return;
    }
    public int LCM(int gob, int gcd){
        return gob / gcd;
    }

    public int GCD(int a, int b){
        if(b == 0){return a;}
        return GCD(b, a % b);
    }
}
