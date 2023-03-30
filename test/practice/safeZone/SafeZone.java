package practice.safeZone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SafeZone {

    int[][] board1 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
    int[][] board2 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
    int[][] board3 = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};

    int[][] area;

    void init(int[][] board){
        area = new int[board.length+2][board[0].length+2];
        //지역을 둘러싼 0을 제외한 부분을 지뢰가 없다는 뜻의 1을 채워둠
        for(int i = 1; i < area.length-1; i++) {
            for(int j = 1; j < area[i].length-1; j++){
                area[i][j] = 1;
            }
        }
    }

    void findBomm(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    area[i][j+1] = 2;
                    area[i+2][j+1] = 2;
                    area[i+1][j] = 2;
                    area[i+1][j+2] = 2;
                    area[i][j] = 2;
                    area[i+1][j+1] = 2;
                    area[i][j+2] = 2;
                    area[i+2][j] = 2;
                    area[i+2][j+2] = 2;
                }
            }
        }
    }

    @Test
    void safeZoneTest1(){
        int answer = 0;
        init(board1);
        findBomm(board1);
        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area[i].length; j++){
                if(area[i][j] == 1){
                    answer++;
                }
            }
        }
        Assertions.assertEquals(16, answer);
    }

    @Test
    void safeZoneTest2(){
        int answer = 0;
        init(board2);
        findBomm(board2);
        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area[i].length; j++){
                if(area[i][j] == 1){
                    answer++;
                }
            }
        }
        Assertions.assertEquals(13, answer);
    }

    @Test
    void safeZoneTest3(){
        int answer = 0;
        init(board3);
        findBomm(board3);
        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area[i].length; j++){
                if(area[i][j] == 1){
                    answer++;
                }
            }
        }
        Assertions.assertEquals(0, answer);
    }
}
