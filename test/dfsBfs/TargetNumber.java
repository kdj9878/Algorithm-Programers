package dfsBfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TargetNumber {

    /*n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. */

    /*사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.*/

    /*제한사항
    주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
    각 숫자는 1 이상 50 이하인 자연수입니다.
    타겟 넘버는 1 이상 1000 이하인 자연수입니다.*/

    @Test
    @DisplayName("타겟 넘버")
    void targetNumber(){
        int answer = 0;
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        dfs(numbers, 0, target, 0);
        answer = this.count;

        System.out.println(answer);
    }

    int count = 0;

    public void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){
            if (target == result){
                this.count++;
            }
            return;
        }

        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        dfs(numbers, depth+1, target, add);
        dfs(numbers, depth+1, target, sub);

    }
}
