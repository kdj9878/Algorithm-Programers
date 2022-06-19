package stackQueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class stockPrice {

    /*초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.*/

    /*제한사항
    prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    prices의 길이는 2 이상 100,000 이하입니다.*/

    Queue<Integer> queue = new LinkedList<>();

    public void checkNext(int start, int[] prices, int idx){
        int count = 0;
        for(int i = idx; i < prices.length; i++){
            count++;
            if(start > prices[i]){
                break;
            }
        }
        queue.add(count);
    }

    @Test
    @DisplayName("주식가격")
    void stockPrice(){
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            checkNext(prices[i], prices, i+1);
        }

        int j = 0;
        while(!queue.isEmpty()){
            answer[j] = queue.poll();
            j++;
        }
    }
}
