package stackQueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class PassingTruck {

    /*문제 설명
    트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
    모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
    다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

    예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
    무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.*/

    /*solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
    이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.*/

    /*제한 조건
    bridge_length는 1 이상 10,000 이하입니다.
    weight는 1 이상 10,000 이하입니다.
    truck_weights의 길이는 1 이상 10,000 이하입니다.
    모든 트럭의 무게는 1 이상 weight 이하입니다.*/

    Queue<Integer> weighting = new LinkedList<>();
    Queue<Integer> passing = new LinkedList<>();
    
    static int bridge_length = 2;
    static int weight = 10;
    static int[] truck_weights = {7,4,5,6};

    void init(int[] truck_weights){
        for(int truck : truck_weights) weighting.add(truck);
    }
    
    @Test
    @DisplayName("다리를 지나는 트럭")
    void passingTruck(){
        init(truck_weights);
        int sum = 0;
        int time = 0;

        while(!weighting.isEmpty()) {
            int truck = weighting.poll();

            while(true) {
                if(passing.isEmpty()) {
                    passing.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if(passing.size() == bridge_length) {
                    sum -= passing.poll();
                } else  {
                    if(sum + truck <= weight) {
                        passing.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        passing.add(0);
                        time++;
                    }
                }
            }
        }

        System.out.println(time + bridge_length);
    }
}
