package practice;

import org.junit.jupiter.api.Test;

public class Decryption {
    /*문제 설명
    군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.

    암호화된 문자열 cipher를 주고받습니다.
    그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
    문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ cipher의 길이 ≤ 1,000
    1 ≤ code ≤ cipher의 길이
    cipher는 소문자와 공백으로만 구성되어 있습니다.
    공백도 하나의 문자로 취급합니다.*/

    int code = 4;
    String cipher = "dfjardstddetckdaccccdegk";

    @Test
    void decryption(){
        StringBuilder answer = new StringBuilder();
        for(int i = code; i <= cipher.length(); i += code){
            answer.append(cipher.substring(i-1, i));
        }
        System.out.println(answer.toString());
    }
}
