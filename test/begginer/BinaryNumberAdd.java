package begginer;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class BinaryNumberAdd {

    /*문제 설명
    이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때, 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.

    제한사항
    return 값은 이진수를 의미하는 문자열입니다.
            1 ≤ bin1, bin2의 길이 ≤ 10
    bin1과 bin2는 0과 1로만 이루어져 있습니다.
    bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.*/

    String bin1 = "10";
    String bin2 = "11";

    @Test
    void binaryNumberAdd(){
        String answer = "";
        int[] intBin1 = Stream.of(bin1.split("")).mapToInt(Integer::parseInt).toArray();
        int[] intBin2 = Stream.of(bin2.split("")).mapToInt(Integer::parseInt).toArray();

        boolean digit = false;
        for(int binVal : intBin1){

        }
    }
}