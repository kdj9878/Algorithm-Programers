package tipsTown;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemovePair {

    Set<String> alpa = new HashSet<>();

    void dataSave(String s){
        char[] chrArr = s.toCharArray();
        for(char chr : chrArr) alpa.add(String.valueOf(chr));
    }

    // 똑같은 문자열이 2개 있을 경우 해당 문자열 반환
    String find(String s){
        dataSave(s);
        Iterator it = alpa.iterator();
        while(it.hasNext()){
            String next = it.next().toString();
            String regex = next + "{2,}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()) return next + next;
        }
        return "false";
    }

    @ParameterizedTest
    @ValueSource(strings = {"baabaa", "cdcd"})
    @DisplayName("짝지어 제거하기")
    void removePair(String s){
        int answer = -1;

        boolean flag = false;
        while(!flag){
            String result = find(s);
            if(result.equals("false")){
                answer = 0;
                flag = true;
            }

            s = s.replaceAll(result, "");
            if(s.length() == 0){
                answer = 1;
                flag = true;
            }
        }
    }
}
