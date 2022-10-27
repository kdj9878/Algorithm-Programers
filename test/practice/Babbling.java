package practice;

import org.junit.jupiter.api.Test;

public class Babbling {

    String[] ena_babbling = {"aya", "ye", "woo", "ma"};

    String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

    @Test
    void solution() {
        int answer = 0;

        for(int i = 0; i < babbling.length; i++){
            String prevStr = "";
            for(int j = 0; j < ena_babbling.length;){
                if(babbling[i].equals("")){
                    answer++;
                    break;
                }

                if(babbling[i].indexOf(ena_babbling[j]) > -1 && !prevStr.equals(ena_babbling[j])){
                    prevStr = ena_babbling[j];
                    babbling[i] = babbling[i].replaceFirst(ena_babbling[j], "");
                    j = 0;
                    continue;
                }
                j++;
            }
        }


        System.out.println(answer);;
    }
}
