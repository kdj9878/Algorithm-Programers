package begginer.alienDictionary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlienDictionary {

    int findDic(String[] spell, String[] dic){
        int answer = 2;
        boolean breakFlag = false;
        int spellLen = spell.length;
        for(String dicSp : dic){
            int dicLen = dicSp.length();
            int ansLen = dicLen - spellLen;
            for(String sp : spell){
                dicSp = dicSp.replaceFirst(sp, "");
            }
            if(ansLen == dicSp.length()){
                answer = 1;
                breakFlag = true;
            }
            if(breakFlag) break;
        }
        return answer;
    }

    @Test
    void testCase1(){
        String[] spell = {"p", "o", "s"};
        String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
        int answer = findDic(spell, dic);
        Assertions.assertEquals(2, answer);
    }

    @Test
    void testCase2(){
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        int answer = findDic(spell, dic);
        Assertions.assertEquals(1, answer);
    }

    @Test
    void testCase3(){
        String[] spell = {"s", "o", "m", "d"};
        String[] dic = {"moos", "dzx", "smm", "sunmmo", "som"};
        int answer = findDic(spell, dic);
        Assertions.assertEquals(2, answer);
    }
}
