package practice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AtoB {

    /*문제 설명
    문자열 before와 after가 매개변수로 주어질 때, before의 순서를 바꾸어 after를 만들 수 있으면 1을, 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.

    제한사항
    0 < before의 길이 == after의 길이 < 1,000
    before와 after는 모두 소문자로 이루어져 있습니다.*/

    String before = "allpe";
    String after = "apple";

    @Test
    void aToB(){
        List<String> beforeList = Stream.of(before.split("")).collect(Collectors.toList());
        List<String> afterList = Stream.of(after.split("")).collect(Collectors.toList());
        for(String bfStr : beforeList){
            afterList.remove(bfStr);
        }
        if(afterList.size() == 0){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
