package introduction;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class IHateEvenNumber {

    int n = 10;

    /*문제 설명
    정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.*/

    //내가 푼 풀이(비효율적)
    @Test
    void iHateEvenNumber(){
        ArrayList<Integer> tempList = new ArrayList<>();
        for(int i = 1; i <= n; i++) if(i % 2 != 0) tempList.add(i);
        int[] answer = tempList.stream().mapToInt(x -> x).toArray();
        System.out.println("배열 : " + Arrays.toString(answer));
    }

    //다른 사람이 푼 풀이(효율적)
    @Test
    void iHateEvenNumberSolveOtherPeople(){
        int cnt = 0;

        /**
         * n이 짝수일 경우 홀수와 짝수는 둘다 n/2
         * n이 홀수일 경우에는 n 자기 자신이 홀수이므로 (n/2 + 1)
         */

        if(n % 2 == 0) cnt = n/2;
        else cnt = n/2 + 1;

        int[] result = new int[cnt];
        int num = 1;

        for(int i=0; i<result.length; i++){
            result[i] = num;
            num = num + 2;
        }

        System.out.println("배열 : " + Arrays.toString(result));
    }
}
