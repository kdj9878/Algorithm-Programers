package begginer;

import org.junit.jupiter.api.Test;

public class Parallel {

    /**
     * 평행
     * https://school.programmers.co.kr/learn/courses/30/lessons/120875
     */

    /*문제 설명
    점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.

     [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
    주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.

    제한사항
    0 ≤ dots의 원소 ≤ 100
    dots의 길이 = 4
    dots의 원소의 길이 = 2
    dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
    서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
    두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
    임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.*/

    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;
    int x3 = 0;
    int y3 = 0;
    int x4 = 0;
    int y4 = 0;

    void init(int[][] dots){
        x1 = dots[0][0];
        y1 = dots[0][1];
        x2 = dots[1][0];
        y2 = dots[1][1];
        x3 = dots[2][0];
        y3 = dots[2][1];
        x4 = dots[3][0];
        y4 = dots[3][1];
    }

    int[][]dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};

    //제출 시 2번 케이스만 실패(Why?)
    @Test
    void parallel(){
        init(dots);

        /* 평행을 이루는 조건 -> 기울기가 같되, y절편이 다르다(y절편 : x가 0일 경우 y)
         * 하지만 이 문제는 조건에서 일치하는 경우에도 1을 반환
        */

        //dots 1,2 <-> dots 3,4
        if(calInc(x2 - x1, y2 - y1) == calInc(x4 - x3, y4 - y3)) {
            System.out.println(1);
            return;
        };

        //dots 1,3 <-> dots 2,4
        if(calInc(x3 - x1, y3 - y1) == calInc(x4 - x2, y4 - y2)) {
            System.out.println(1);
            return;
        };

        //dots 1,4 <-> dots 2,3
        if(calInc(x4 - x1, y4 - y1) == calInc(x3 - x2, y3 - y2)) {
            System.out.println(1);
            return;
        };

        System.out.println(0);
    }

    double calInc(int x, int y){
        return (double)y/(double)x;
    }
}
