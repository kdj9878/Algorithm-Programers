package begginer;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSixNine {

    /*문제 설명
    머쓱이는 친구들과 369게임을 하고 있습니다. 369게임은 1부터 숫자를 하나씩 대며 3, 6, 9가 들어가는 숫자는 숫자 대신 3, 6, 9의 개수만큼 박수를 치는 게임입니다.
    머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 return 하도록 solution 함수를 완성해보세요.*/
    int order = 29423;

    //내 풀이
    @Test
    void threeSixNine(){
        int answer = 0;
        answer = Math.toIntExact(Stream.of(String.valueOf(order).split(""))
                .filter(x -> x.equals("3") || x.equals("6") || x.equals("9"))
                .collect(Collectors.counting()));
        System.out.println(answer);
    }

    //다른 사람 풀이
    @Test
    void threeSixNineOther(){
        int answer = solution(order);
        System.out.println(answer);
    }


    public int solution(int order) {
        int answer = 0;
        while(true){
            if(order == 0){
                break;
            }
            if(order % 10 == 3 || order % 10 == 6 || order % 10 == 9){
                answer++;
            }
            order = order / 10;
        }
        return answer;
    }
}
