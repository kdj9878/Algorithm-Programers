package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JadenCase {

    /*문제 설명
    JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
    단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
    문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.*/

    /*제한 조건
    s는 길이 1 이상 200 이하인 문자열입니다.
    s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
    숫자는 단어의 첫 문자로만 나옵니다.
    숫자로만 이루어진 단어는 없습니다.
    공백문자가 연속해서 나올 수 있습니다.*/

    // 공백이 하나 이상 있는 패턴을 검사
    Pattern p = Pattern.compile("(\\s){1,}");

    @ParameterizedTest
    @ValueSource(strings = {"3people unFollowed me", "for the last week"})
    @DisplayName("JadenCase")
    void jadenCase(String s){
        String answer = "";
        int asci;

        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        sb.append(s);

        asci = (int)s.charAt(0); // 아스키코드로 변환
        if(97 <= asci && asci <= 122){  // 소문자일 경우
            char toUpper = (char)(asci - 32);
            sb.replace(0, 1, String.valueOf(toUpper));
        }

        Matcher m = p.matcher(s);
        while(m.find()){
            int end = m.end();  // 공백 다음 글자 시작 위치
            if(end == sb.length()){
                continue;
            }
            asci = (int)s.charAt(end);
            if(97 <= asci && asci <= 122){
                char toUpper = (char)(asci - 32);
                sb.replace(end, end+1, String.valueOf(toUpper));
            }
        }

        answer = sb.toString();

        System.out.println("answer => " + answer);

    }
}