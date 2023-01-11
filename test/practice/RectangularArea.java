package practice;

import org.junit.jupiter.api.Test;

public class RectangularArea {

    /*문제 설명
    2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
    직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때, 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.

    제한사항
    dots의 길이 = 4
    dots의 원소의 길이 = 2
            -256 < dots[i]의 원소 < 256
    잘못된 입력은 주어지지 않습니다.*/


    int[][] dots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}};

    @Test
    void rectangularArea(){
        int xlength = 0;
        int ylength = 0;
        //가로변 찾기(y좌표가 같고 x좌표가 다른 점들의 거리)
        for(int i = 0; i < dots.length; i++){
            if(dots[0][1] == dots[i][1] && dots[0][0] != dots[i][0]){
                xlength = Math.abs(dots[i][0] - dots[0][0]);
            }
        }

        //세로변 찾기(x좌표가 같고 y좌표가 다른 점들의 거리)
        for(int i = 0; i < dots.length; i++){
            if(dots[0][0] == dots[i][0] && dots[0][1] != dots[i][1]){
                ylength = Math.abs(dots[i][1] - dots[0][1]);
            }
        }

        System.out.println(xlength * ylength);
    }
}
