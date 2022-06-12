package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class oneTwoThree {


    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6})
    void test(int n){
        String answer = "";
        int mod;
        int div;
        int[] conv = {1, 2, 4};

        n = n - 1;

        while(true) {
            mod = n % 3; // 나머지
            div = n / 3; // 몫

            n = div - 1;

            answer = Integer.toString(conv[mod]) + answer;

            if (n < 0) {
                break;
            }
        }
        System.out.printf("answer => %s\r\n", answer);
    }

}
