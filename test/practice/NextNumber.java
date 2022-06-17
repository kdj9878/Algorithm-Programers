package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class NextNumber {

    // 1의 개수를 반환
    long checkCount(int n){
        String str = Integer.toString(n, 2);
        // 효율성 테스트5번 1개 틀림
        return str.length() - str.replace(String.valueOf('1'), "").length();
        // 효율성 0점
        // return str.chars().mapToObj(ch -> (char)ch).filter( ch -> ch == '1').count();
    }

    // 첫 번째 코드(효율성 0점)
    @ParameterizedTest
    @ValueSource(ints = {78, 15})
    @DisplayName("다음 큰 숫자")
    void nextNumber(int n){
        int answer = 0;
        boolean state = false;
        answer = n;
        while(!state){
            answer++;
            if(checkCount(answer) == checkCount(n)){
                state = true;
            }
        }
        System.out.println(answer);
    }

    // 두 번째 코드(효율성 통과)
    @ParameterizedTest
    @ValueSource(ints = {78, 15})
    @DisplayName("다음 큰 숫자(효율성 통과)")
    void nextNumber2(int n){
        int answer = 0;
        boolean state = false;
        answer = n;
        while(!state){
            answer++;
            if(Integer.bitCount(answer) == Integer.bitCount(n)){
                state = true;
            }
        }
        System.out.println(answer);
    }

}
