package practice.lv1.bundleOfCards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BundleOfCards {



    Map<Integer, String> goalMap = new HashMap<>();
    Queue<String> card1 = new LinkedList<>();
    Queue<String> card2 = new LinkedList<>();

    void init(String[] goal, String[] cards1, String[] cards2){
        for(int i = 0; i < goal.length; i++) goalMap.put(i, goal[i]);
        for(String c1 : cards1) card1.add(c1);
        for(String c2 : cards2) card2.add(c2);
    }

    @Test
    String bundleOfCards(String[] cards1, String[] cards2, String[] goal){
        String answer = "Yes";
        init(goal, cards1, cards2);
        for(int i = 0; i < goal.length; i++){
            if(card1.size() != 0 && card1.peek().equals(goalMap.get(i))){
                card1.poll();
                continue;
            }
            else if(card2.size() != 0 && card2.peek().equals(goalMap.get(i))){
                card2.poll();
                continue;
            }
            answer = "No";
            break;
        }
        return answer;
    }

    @Test
    void testCase1(){
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = bundleOfCards(cards1, cards2, goal);
        Assertions.assertEquals("Yes", answer);
    }

    @Test
    void testCase2(){
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        String answer = bundleOfCards(cards1, cards2, goal);
        Assertions.assertEquals("No", answer);
    }
}
