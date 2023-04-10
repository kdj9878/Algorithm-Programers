package begginer.additionalHiddenNumbers2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionOfHiddenNumbers2 {

    /**
     * 기존 로직(제출 시 테스트 케이스 2번 실패)
     * @param my_string
     */
    int myoExplanation(String my_string){
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
        return answer;
    }

    private boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Test
    void myExplanationTestCase1(){
        String my_string1 = "aAb1B2cC34oOp";
        int result = myoExplanation(my_string1);
        Assertions.assertEquals(37, result);
    }

    @Test
    void myExplanationTestCase2(){
        String my_string2 = "1a2b3c4d123Z";
        int result = myoExplanation(my_string2);
        Assertions.assertEquals(133, result);
    }

    @Test
    void otherTestCase1(){
        String my_string1 = "1000";
        int result = otherPeopleExplanation(my_string1);
        Assertions.assertEquals(1000, result);
    }

    @Test
    void otherTestCase2(){
        String my_string2 = "aAb1B2cC34oOp";
        int result = otherPeopleExplanation(my_string2);
        Assertions.assertEquals(37, result);
    }

    @Test
    void otherTestCase3(){
        String my_string3 = "1a2b3c4d123Z";
        int result = otherPeopleExplanation(my_string3);
        Assertions.assertEquals(133, result);
    }


    /**
     * 도움 받은 풀이
     * @param my_string
     */
    int otherPeopleExplanation(String my_string){
        int answer = 0;
        String[] arr = my_string.replaceAll("[^0-9]", " ").split(" ");
        for(String str : arr){
            if(!"".equals(str)){
                answer += Integer.parseInt(str);
            }
        }
        return answer;
    }
}
