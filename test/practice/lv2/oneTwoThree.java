package practice.lv2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Stack;

public class oneTwoThree {

    /**
     * 124 나라의 숫자 - 내 코드는 실패
     * https://school.programmers.co.kr/learn/courses/30/lessons/12899
     */

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

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6})
    void oneTwoThreeTest2(int n){
        // 1 = 1
        // 2 = 2
        // 3 = 4
        // n째 자리 숫자 = *3

        // 전체를 3으로 나누어 3진수로 만들어준다.
        // 첫째자리 숫자부터 0이 나오면 앞에 자리 숫자로 대체해 준다.
        // 3을 4로 바꾸어 준다.
        String answer = "";

        StringBuilder sb =  new StringBuilder();
        Stack<Integer> numStack = new Stack<Integer>();
        while(n > 0){
            int remainder = n%3;
            n = n/3;

            numStack.add(remainder);
        }

        // 3진수를 124진수로 바꾸어준다.
        int stSize = numStack.size();
        while(stSize > 0){
            stSize++;
            if(numStack.size() == 1){
                sb.append(numStack.pop());
                break;
            }

            int first = numStack.pop();
            int second = numStack.pop();

            if(second == 0){
                switch(first){
                    case 4 : first = 2; break;
                    case 2 : first = 1; break;
                    case 1 : first = 0; break;
                }
                second = 4;
            }
            if(first != 0) {
                sb.append(first);
            }
            numStack.push(second);
        }

        answer = sb.toString();
        System.out.println(answer);
    }
}
