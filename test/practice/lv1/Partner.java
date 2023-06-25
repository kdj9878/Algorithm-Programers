package practice.lv1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Partner {

    /**
     * 숫자 짝꿍
     * https://school.programmers.co.kr/learn/courses/30/lessons/131128
     */

    String X = "123217348789437109374189740987498749071209478209748921749721809578974892740921847198074389214650982173498748971230947891741987489234";
    String Y = "42531765413129837897389217387129837891273878129738971948712849789124789217893789127387128379817283971289379817298378917238971289378568916498216984182371892738917389721381278937128937891723987129837891273988139";

    boolean justZero(String str){
        String[] arr = str.split("");
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].equals("0")){
                return false;
            }
        }
        return true;
    }

    @Test
    void partner(){
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < X.length(); i++){
            String x = String.valueOf(X.charAt(i));
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int j = 0; j < Y.length(); j++){
            String y = String.valueOf(Y.charAt(j));
            if(map.get(y) != null && map.get(y) != 0){
                sb.append(y);
                map.put(y, map.getOrDefault(y, 1) - 1);
            }
        }

        // 짝꿍이 없을 경우
        if(sb.length() == 0) {
            System.out.println("-1");
            return;
        }
        // 짝꿍이 0일 경우
        else if(justZero(sb.toString())) {
            System.out.println(0);
            return;
        }
        else{
            StringBuilder sb2 = new StringBuilder();
            Arrays.stream(sb.toString().split("")).mapToInt(Integer::parseInt)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .map(x -> String.valueOf(x))
                    .forEach(str -> sb2.append(str));
            answer = sb2.toString();
        }

        System.out.println(answer);

    }
}
