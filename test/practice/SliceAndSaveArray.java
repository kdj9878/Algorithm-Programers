package practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SliceAndSaveArray {
    /*문제 설명
    문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ my_str의 길이 ≤ 100
    1 ≤ n ≤ my_str의 길이
    my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.*/

    String my_str = "abc1Addfggg4556b";

    int n = 6;

    @Test
    void sliceAndSaveArray(String my_str){
        int mok = my_str.length() / n;
        int mod = my_str.length() % n;
        String[] answer = new String[mod == 0 ? mok : mok + 1];

        for(int i = 0; i < answer.length; i++){
            if(my_str.length() < n){
                answer[i] = my_str;
                break;
            }
            String subStr = my_str.substring(0, n);
            answer[i] = subStr;
            my_str = my_str.substring(n, my_str.length());
        }
        System.out.println(Arrays.toString(answer));
    }
}
