package stackQueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CorrectParentheses {

    /*괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

    "()()" 또는 "(())()" 는 올바른 괄호입니다.
    ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
    '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.*/

    /*제한사항
    문자열 s의 길이 : 100,000 이하의 자연수
    문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.*/

    // 특정 문자열의 개수를 반환하는 함수
    int countChar(String str, char chr){
        return str.length() - str.replace(String.valueOf(chr), "").length();
    }

    @ParameterizedTest
    @ValueSource(strings = {"()()", "(())()", ")()(", "(()("})
    @DisplayName("올바른 괄호")
    void collectParenthesis(String s){
        boolean answer = true;
        if(s.startsWith(")") || s.endsWith("("))  answer = false;
        if(countChar(s, '(') != countChar(s, ')')) answer = false;

        char[] charArr = s.toCharArray();
        int isCollect = 0;
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == '(') isCollect -= 1;
            if(charArr[i] == ')') isCollect += 1;
            if(isCollect > 0) answer = false;
        }

        System.out.println(answer);
    }
}
