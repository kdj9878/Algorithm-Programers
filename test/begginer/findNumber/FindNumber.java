package practice.lv0.findNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindNumber {

    @Test
    void findNumberTest1(){
        int answer = 0;
        int num = 29183;
        int k = 1;

        String castNum = String.valueOf(num);
        String castK = String.valueOf(k);
        answer = castNum.indexOf(castK) == -1 ? -1 : castNum.indexOf(castK) + 1;
        Assertions.assertEquals(3, answer);
    }

    @Test
    void findNumberTest2(){
        int answer = 0;
        int num = 232443;
        int k = 4;

        String castNum = String.valueOf(num);
        String castK = String.valueOf(k);
        answer = castNum.indexOf(castK) == -1 ? -1 : castNum.indexOf(castK) + 1;
        Assertions.assertEquals(4, answer);
    }

    @Test
    void findNumberTest3(){
        int answer = 0;
        int num = 123456;
        int k = 7;

        String castNum = String.valueOf(num);
        String castK = String.valueOf(k);
        answer = castNum.indexOf(castK) == -1 ? -1 : castNum.indexOf(castK) + 1;
        Assertions.assertEquals(-1, answer);
    }


}
