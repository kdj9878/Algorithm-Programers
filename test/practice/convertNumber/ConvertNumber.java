package practice.convertNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConvertNumber {

    @Test
    void convertNumber_testCase_1(){
        int x = 1;
        int y = 12;
        int n = 5;
        Assertions.assertEquals(2, convertNumber(x, y, n));
    }

    @Test
    void convertNumber_testCase_2(){
        int x = 10;
        int y = 40;
        int n = 30;
        Assertions.assertEquals(1, convertNumber(x, y, n));
    }

    @Test
    void convertNumber_testCase_3(){
        int x = 2;
        int y = 5;
        int n = 4;
        Assertions.assertEquals(-1, convertNumber(x, y, n));
    }

    //목표인 y가 될 때까지 몇 번의 연산이 이루어졌는지
    int convertNumber(int x, int y, int n){
        int[] dp = new int[y + 1];
        for (int i = x; i < y + 1; i++) {
            if (i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            if (i * 2 <= y) {
                dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
            }
            if (i * 3 <= y) {
                dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
            }
            if (i + n <= y) {
                dp[i + n] = (dp[i + n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
            }
        }

        return dp[y];
    }
}
