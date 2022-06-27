package tipsTown;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemovePairImproving {

    StringBuilder sb;

    void init(){
        sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            sb.append(String.valueOf((char)(97+i)) + "{2,}");
            if(i != 25){
                sb.append("|");
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"baabaa", "cdcd"})
    @DisplayName("짝지어 제거하기")
    void removePair(String s){
        int answer = -1;
        init();
        String regex = sb.toString();
        boolean flag = false;
        while(!flag){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){
                s = s.replaceAll(regex, "");
                continue;
            }

            if(s.length() == 0){
                answer = 1;
            }
            else{
                answer = 0;
            }

            flag = true;
        }

        System.out.println("answer => " + answer);
    }
}
