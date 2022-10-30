package practice;

import org.junit.jupiter.api.Test;

public class NextToNumber {
    /*문제 설명
    등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.

    제한사항
    2 < common의 길이 < 1,000
    -1,000 < common의 원소 < 2,000
    등차수열 혹은 등비수열이 아닌 경우는 없습니다.
    공비가 0인 경우는 없습니다.*/

    int[] common = {1, 2, 3, 4};

    @Test
    void nextToNumber(){
        int answer = 0;
        int[] chaArr = new int[common.length - 1];
        for(int i = 0; i < common.length-1; i++){
            chaArr[i] = common[i+1] - common[i];
        }

        //등차수열일 경우
        if(chaArr[0] == chaArr[1]){
            answer = common[common.length-1] + chaArr[0];
        }
        //등비수열일 경우
        else{
            int mok = chaArr[1]/chaArr[0];
            answer = common[common.length-1] * mok;
        }

        System.out.println(answer);
    }
}
