package practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

public class AdditionOfHiddenNumbers {
    /*문제 설명
    문자열 my_string이 매개변수로 주어집니다. my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ my_string의 길이 ≤ 1,000
    1 ≤ my_string 안의 자연수 ≤ 1000
    연속된 수는 하나의 숫자로 간주합니다.
    000123과 같이 0이 선행하는 경우는 없습니다.
    문자열에 자연수가 없는 경우 0을 return 해주세요.*/

    /**
     * 기존 로직(제출 시 테스트 케이스 2번 실패)
     * @param my_string
     */
    @ParameterizedTest
    @ValueSource(strings = "1000")
    void additionalOfHiddenNumbers(String my_string){
        int answer = 0;
        boolean checkFlag = false;
        String tempStr = "";

        for(int i = 0; i < my_string.length(); i++){
            String str = my_string.substring(i, i+1);
            //숫자 시작 지점 검색
            if(!checkFlag && isNumber(str)){
                checkFlag = true;
                tempStr += str;
            }
            //숫자가 한 자리수 이상일 경우
            else if(checkFlag && isNumber(str)){
                tempStr += str;
                if(i == my_string.length()-1){
                    answer += Integer.parseInt(tempStr);
                }
            }
            //숫자가 끊키고 영어가 나올 경우
            else if(checkFlag && !isNumber(str)){
                checkFlag = false;
                answer += Integer.parseInt(tempStr);
                tempStr = "";
            }
        }
        System.out.println(answer);
    }

    private boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * 도움 받은 풀이
     * @param my_string
     */
    @ParameterizedTest
    @ValueSource(strings = {"1000","aAb1B2cC34oOp", "1a2b3c4d123Z"})
    void additionalOfHiddenNumbers2(String my_string){
        int answer = 0;
        String[] arr = my_string.replaceAll("[^0-9]", " ").split(" ");
        for(String str : arr){
            if(!"".equals(str)){
                answer += Integer.parseInt(str);
            }
        }
        System.out.println(answer);
    }
}
