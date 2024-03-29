package practice.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionOfNumber {
    /**
     * 숫자의 표현
     * https://school.programmers.co.kr/learn/courses/30/lessons/12924
     */

    /*문제 설명
    Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

        1 + 2 + 3 + 4 + 5 = 15
        4 + 5 + 6 = 15
        7 + 8 = 15
        15 = 15
    자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.*/

    /*제한사항
    n은 10,000 이하의 자연수 입니다.*/

    int count = 0;
    int target;
    int num;

    void init(int n){
        target = n;
    }

    int recursive(int n){
        if(num > target){
            num = 0;
            return 0;
        }
        else if(num == target){
            count++;
            num = 0;
            return 0;
        }

        num += n;

        return recursive(n+1);
    }

    @Test
    @DisplayName("숫자의 표현")
    void expressionOfNumber(){
        int n = 15;
        int answer = 0;
        init(n);
        for(int i = 1; i <= n; i++){
            recursive(i);
        }

        answer = count;

        System.out.println(answer);
    }
}
