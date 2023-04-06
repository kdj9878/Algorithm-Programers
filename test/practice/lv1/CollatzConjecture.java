package practice.lv1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CollatzConjecture {

    static int count = 0;

    @ParameterizedTest
    @DisplayName("콜라츠 추측")
    @ValueSource(ints = {626331})
    public void solution(int num) {
        int answer = 0;

        // int로 할 경우 표현 범위를 넘어서기 때문에 long으로 형변환을 함
        long castedNum = num;

        while(castedNum != 1){
            if(castedNum%2 > 0){
                castedNum = (castedNum * 3) + 1;
            } else {
                castedNum = castedNum / 2;
            }
            count++;

            if(count == 500) {
                count = -1;
                break;
            }
        }
        answer = count;

        System.out.println(answer);
    }
}
