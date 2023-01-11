package practice;

import org.junit.jupiter.api.Test;

import java.util.*;

public class PickTangerines {

    int k = 6;
    int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

    List<Node> nodeList = new ArrayList<>();

    class Node implements Comparable<Node>{
        int size;
        int amount;

        public Node(int size, int amount){
            this.size = size;
            this.amount = amount;
        }

        public int getSize(){
            return this.size;
        }
        public int getAmount(){
            return this.amount;
        }
        public void plusAmount(){
            this.amount += 1;
        }
        @Override
        public int compareTo(Node n){
            return n.getAmount() - this.amount;
        }

    }

    @Test
    void pickTangerines(){
        int answer = 0;
        int amountSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int tan : tangerine) map.put(tan, map.getOrDefault(tan, 0) +1);
        for( Map.Entry<Integer, Integer> entry : map.entrySet()){
            nodeList.add(new Node(entry.getKey(), entry.getValue()));
        }
        Collections.sort(nodeList);
        for (Node node : nodeList) {
            //처음 로직
            /*int amount = node.getAmount();
            if ((amountSum + amount) <= k) {
                amountSum += amount;
                answer++;
            }*/
            k -= node.getAmount();
            answer++;
            if(k < 1){
                break;
            }
        }

        System.out.println(answer);
    }
}
