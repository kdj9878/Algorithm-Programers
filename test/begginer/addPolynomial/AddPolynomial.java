package begginer.addPolynomial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddPolynomial {


    String addPolynomial(String polynomial){
        String answer = "";
        String[] arr = polynomial.split(" ");
        int xSum = 0;
        int numSum = 0;
        for(String str : arr){
            if(str.indexOf("x") > -1){
                if(str.length() == 1){
                    xSum += 1;
                }
                else{
                    String temp = str.replace("x", "");
                    xSum += Integer.parseInt(temp);
                }
            }
            else if(!"+".equals(str)){
                numSum += Integer.parseInt(str);
            }
        }
        boolean passFlag = false;
        if(xSum == 1){
            answer += "x";
        }
        else if(xSum == 0){
            passFlag = true;
        }
        else{
            answer += xSum + "x";
        }

        if(passFlag){
            answer += numSum;
        }
        else if(!passFlag && numSum != 0){
            answer += " + " + numSum;
        }

        return answer;
    }

    @Test
    void addPolynomialTestCase1(){
        String testCase = "3x + 7 + x";
        String answer = addPolynomial(testCase);
        Assertions.assertEquals("4x + 7", answer);


    }

    @Test
    void addPolynomialTestCase2(){
        String testCase = "x + x + x";
        String answer = addPolynomial(testCase);
        Assertions.assertEquals("3x", answer);
    }
}
