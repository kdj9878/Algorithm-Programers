package practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class Partner {

    String X = "12321";
    String Y = "42531";

    @Test
    void partner(){
        String answer = "";
        String tallStr = X.length() >= Y.length() ? X : Y;
        String shortStr = X.length() < Y.length() ? X : Y;

        int cnt = 0;
        for(int i = 0; i < shortStr.length(); i++){
            for(int j = 0; j < tallStr.length(); j++){
                if((int)shortStr.charAt(i) == (int)tallStr.charAt(j)){
                    answer += String.valueOf(shortStr.charAt(i));
                    cnt++;
                    break;
                }
            }
        }
        // 짝꿍이 없을 경우
        if(cnt == 0) {
            System.out.println(-1);
            return;
        }
        // 짝꿍이 0일 경우
        else if(Integer.parseInt(answer) == 0){
            System.out.println(0);
            return;
        }
        else{
            StringBuilder sb = new StringBuilder();
            Arrays.stream(answer.split("")).mapToInt(Integer::parseInt)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .map(x -> String.valueOf(x))
                    .forEach(str -> sb.append(str));
            answer = sb.toString();
        }

        System.out.println(answer);

    }
}
