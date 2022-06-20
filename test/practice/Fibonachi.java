package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Fibonachi {

    /*피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

    예를들어

    F(2) = F(0) + F(1) = 0 + 1 = 1
    F(3) = F(1) + F(2) = 1 + 1 = 2
    F(4) = F(2) + F(3) = 1 + 2 = 3
    F(5) = F(3) + F(4) = 2 + 3 = 5
    와 같이 이어집니다.

    2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.*/

    /*제한 사항
    n은 2 이상 100,000 이하인 자연수입니다.*/

    int[] fiboArr;

    int fibo(int n){
        if(n <= 1) {
            return n;
        }
        // int 배열을 선언할 경우 빈 공간에 0이 들어가므로 0일 경우 데이터가 없는 상태
        else if(fiboArr[n] == 0){
            return fiboArr[n] = (fibo(n-1) + fibo(n-2))%1234567;
        }else{
            // 데이터가 이미 존재한다면 그 값을 바로 반환
            return fiboArr[n];
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    @DisplayName("피보나치 수")
    void fibonachi(int n){
        int answer = 0;

        fiboArr = new int[n+1];

        fiboArr[0] = 0;
        fiboArr[1] = 1;

        fibo(n);
        answer = fiboArr[n];

        System.out.println("answer => " + answer);
    }
}
