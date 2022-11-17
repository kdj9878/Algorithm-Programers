package practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalcStrings {
    /*문제 설명
    my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.

    제한사항
    연산자는 +, -만 존재합니다.
    문자열의 시작과 끝에는 공백이 없습니다.
    0으로 시작하는 숫자는 주어지지 않습니다.
    잘못된 수식은 주어지지 않습니다.
    5 ≤ my_string의 길이 ≤ 100
    my_string을 계산한 결과값은 1 이상 100,000 이하입니다.
    my_string의 중간 계산 값은 -100,000 이상 100,000 이하입니다.
    계산에 사용하는 숫자는 1 이상 20,000 이하인 자연수입니다.
    my_string에는 연산자가 적어도 하나 포함되어 있습니다.
    return type 은 정수형입니다.
    my_string의 숫자와 연산자는 공백 하나로 구분되어 있습니다.*/

    //처음 제출 성공한 코드
    @ParameterizedTest
    @ValueSource(strings = {"3 + 4", "3 - 7 + 4", "10 + 2 - 8"})
    void calcStrings(String my_string){
        int answer = 0;
        String[] arr = my_string.split(" ");
        for(int i = 0; i + 2 <= arr.length; i += 2){
            String yen = arr[i+1];
            if(i == 0){
                if(yen.equals("+")){
                    answer = toInt(arr[i]) + toInt(arr[i+2]);
                }
                else{
                    answer = toInt(arr[i]) - toInt(arr[i+2]);
                }
            }
            else{
                if(yen.equals("+")){
                    answer += toInt(arr[i+2]);
                }
                else{
                    answer -= toInt(arr[i+2]);
                }
            }
        }
        System.out.println(answer);
    }

    int toInt(String str){
        return Integer.parseInt(str);
    }
}
