package kakao;

import org.junit.jupiter.api.Test;

public class Kakao2 {

    /*
    * 숫자 문자열과 영단어
    * */
    @Test
    void test() {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String answer = "";

        // 대문자를 소문자로 치환
        new_id = new_id.toLowerCase();

        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        new_id = new_id.replaceAll("[^a-z0-9\\.\\-\\_]", "");


        // 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");


        // 마침표가 처음 혹은 끝에 위차한 경우 제거

        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // new_id가 빈 문자열일 경우 a를 대입
        if(new_id.equals("")){
            new_id = "a";
        }

        // 문자열의 길이가 16자 이상이면 15자까지 자르고, 마지막 문자가 .인 경우 제거
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        // new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
        if(new_id.length() <= 2){
            while(new_id.length() < 3){
                // aaaa
                String tempValue = new_id.substring(new_id.length()-1);
                System.out.println(tempValue);
                new_id = new_id + tempValue;
            }
        }

        answer = new_id;
        System.out.print(answer);
    }
}
