package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CollatzConjecture {

    static int count = 0;

    @ParameterizedTest
    @DisplayName("콜라츠 추측")
    @ValueSource(ints = {8, 10, 6242342})
    public void solution(int num) {
        int answer = 0;

        long castedNum = (long) num;

        while(castedNum != 1){
            if(castedNum%2 == 0){
                castedNum = castedNum / 2;
            } else {
                castedNum = (castedNum * 3) + 1;
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
