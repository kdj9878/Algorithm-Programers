package practice;

import org.junit.jupiter.api.Test;

public class Babbling {

    String[] balum = {"aya", "ye", "woo", "ma"};
    String[] repBalum = {"ayaaya", "yeye", "woowoo", "mama"};

    String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

    @Test
    void solution() {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            String tempStr = babbling[i];
            for(int j = 0; j < repBalum.length; j++){
                tempStr = tempStr.replace(repBalum[j], "z");
            }
            for(int z = 0; z < balum.length; z++){
                tempStr = tempStr.replace(balum[z], "");
            }
            if(tempStr.length() == 0){
                answer++;
            }
        }
        System.out.println(answer);;
    }
}
