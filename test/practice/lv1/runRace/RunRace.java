package practice.lv1.runRace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RunRace {

    void prevSwap(String[] players, String calling){
        for(int i = 0; i < players.length; i++){
            if(players[i].equals(calling)){
                String temp = players[i-1];
                players[i-1] = calling;
                players[i] = temp;
            }
        }
    }

    //제출 시 테스트케이스 9 ~ 13번 시간초과
    void prevCode(){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        for(int i = 0; i < callings.length; i++){
            swap(players, callings[i]);
        }
    }

    Map<String, Integer> playerRank;

    void init(String[] players){
        playerRank = new HashMap<>();
        int rank = 0;
        for(String player : players){
            playerRank.put(player, rank);
            rank++;
        }
    }

    void swap(String[] players, String calling){
        //바뀌기 전 순위
        int curRank = playerRank.get(calling);
        //앞에 있는 선수 이름
        String frontPlayerName = players[curRank-1];

        //players 배열 swap
        players[curRank-1] = calling;
        players[curRank] = frontPlayerName;

        //playerRank map 변경
        playerRank.put(calling, curRank-1);
        playerRank.put(frontPlayerName, curRank);

    }

    String[] passedCode(String[] players, String[] callings){
        init(players);
        for(int i = 0; i < callings.length; i++){
            swap(players, callings[i]);
        }
        return players;
    }

    @Test
    void testCase1(){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer = passedCode(players, callings);
        Assertions.assertArrayEquals(new String[]{"mumu", "kai", "mine", "soe", "poe"}, answer);
    }
}
