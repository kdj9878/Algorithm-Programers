package begginer.chickenCoupon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChickenCoupon {

    int chicken1 = 100;
    int chicken2 = 1081;

    @Test
    void chickenCoupon_testCase1(){
        int answer = 0;
        while(chicken1 >= 10){
            chicken1 -= 10;
            chicken1 += 1;
            answer++;
        }
        Assertions.assertEquals(11, answer);
    }

    @Test
    void chickenCoupon_testCase2(){
        int answer = 0;
        while(chicken2 >= 10){
            chicken2 -= 10;
            chicken2 += 1;
            answer++;
        }
        Assertions.assertEquals(120, answer);
    }
}
