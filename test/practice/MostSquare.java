package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MostSquare {

    /*1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
    표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
    (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)*/

    /*제한사항
    표(board)는 2차원 배열로 주어집니다.
            표(board)의 행(row)의 크기 : 1,000 이하의 자연수
    표(board)의 열(column)의 크기 : 1,000 이하의 자연수
    표(board)의 값은 1또는 0으로만 이루어져 있습니다.*/

    @Test
    @DisplayName("가장 큰 정사각형")
    void mostSquare(){
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int answer = 0;
        int[][] newBoard = new int[board.length+1][board[0].length+1];
        // 좌표 (1, 1)을 기준으로 새로운 배열 생성
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                newBoard[i+1][j+1] = board[i][j];
            }
        }

        int max = 0;

        // 만들 수 있는 정사각형 검사
        for(int i=1; i<newBoard.length; i++){
            for(int j=1; j<newBoard[i].length; j++){
                /* 2x2 사각형의 우측하단 꼭짓점을 기준으로 정사각형이 되는지 체크한다.
                 * 현재 값이 1인경우 좌←, 상↑, 좌상↖ 체크
                 * ←, ↑, ↖ 값이 모두 1인경우 정사각형을 만들 수 있음
                 */
                if(newBoard[i][j] == 1){
                    int left = newBoard[i-1][j];    // 좌측 값
                    int up = newBoard[i][j-1];      // 상단 값
                    int leftUp = newBoard[i-1][j-1];// 좌측상단(대각선) 값
                    int min = Math.min(left, Math.min(up, leftUp));
                    newBoard[i][j] = min+1;
                    max = Math.max(max, min+1);
                }
            }
        }
        answer = max * max;
        System.out.println(answer);
    }
}
