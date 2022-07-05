package greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LifeBoat {


    int[] people = {40, 50, 150, 160};
    int limit = 200;

    Queue<Integer> queue = new LinkedList<>();

    void init(ArrayList<Integer> list){
        for(int people : list) queue.add(people);
    }
    
    // 효율성 다 떨어짐 와아앙ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
    @Test
    @DisplayName("구명 보트")
    void lifeBoat(){
        int answer = 0;

        ArrayList<Integer> list = (ArrayList<Integer>)Arrays.stream(people).boxed().collect(Collectors.toList());
        Collections.sort(list); // 오름차순 정렬
        
        while(list.size() != 0){
            int idx = 0;
            int cur = list.get(idx);
            int max = 0;
            int select = -1;
            for(int i = idx+1; i < list.size(); i++){
                if((cur + list.get(i)) <= limit && max < list.get(i)){
                    max = list.get(i);
                    select = i;
                }
            }

            // 같이 탈 사람이 없는 경우
            list.remove(idx);
            if (select != -1) {
                list.remove(select-1);
            }

            answer++;
        }

        System.out.println("answer => " + answer);
    }

    @Test
    @DisplayName("구명 보트 - 다른 사람 풀이")
    void lifeBoatOther(){
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        System.out.println("다른 사람 풀이 answer => " + answer);
    }
}
