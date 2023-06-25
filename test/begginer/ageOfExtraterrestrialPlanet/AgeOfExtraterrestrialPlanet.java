package begginer.ageOfExtraterrestrialPlanet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgeOfExtraterrestrialPlanet {

    String getAge(int age){
        String answer = "";
        while(age > 0){
            int mod = age % 10;
            answer = String.valueOf((char)(mod+97)) + answer;
            age /= 10;
        }
        return answer;
    }

    @Test
    void testCase1(){
        String answer = getAge(23);
        Assertions.assertEquals("cd", answer);
    }

    @Test
    void testCase2(){
        String answer = getAge(51);
        Assertions.assertEquals("fb", answer);
    }

    @Test
    void testCase3(){
        String answer = getAge(100);
        Assertions.assertEquals("baa", answer);
    }

}
