package practice.lv1.babbling2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Babbling2 {

    String[] balum = {"aya", "ye", "woo", "ma"};
    String[] repBalum = {"ayaaya", "yeye", "woowoo", "mama"};


    int getWordCount(String[] babbling) {
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            String tempStr = babbling[i];
            for(int j = 0; j < repBalum.length; j++){
                tempStr = tempStr.replace(repBalum[j], "z");
            }
            for(int z = 0; z < balum.length; z++){
                tempStr = tempStr.replace(balum[z], ".");
            }
            tempStr = tempStr.replace(".", "");
            if(tempStr.length() == 0){
                answer++;
            }
        }
        return answer;
    }

    @Test
    void testCase1(){
        String[] babbling = {"aya", "yee", "u", "maa"};
        int answer = getWordCount(babbling);
        Assertions.assertEquals(1, answer);
    }

    @Test
    void testCase2(){
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int answer = getWordCount(babbling);
        Assertions.assertEquals(2, answer);
    }
}
