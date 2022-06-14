package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Rectangle {

    /*명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다.
    다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다.
    이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.*/

    /*가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
    하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.

    모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
    모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.*/

    /*제한사항
    sizes의 길이는 1 이상 10,000 이하입니다.
    sizes의 원소는 [w, h] 형식입니다.
    w는 명함의 가로 길이를 나타냅니다.
    h는 명함의 세로 길이를 나타냅니다.
    w와 h는 1 이상 1,000 이하인 자연수입니다.*/

    @Test
    @DisplayName("최소 직사각형")
    public void rectangle(){
        // 문제 해결의 관건
        // 명함을 넣을 때 더 긴 부분을 가로로 높여서 넣는다.

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        int answer = 0;

        int max_v=0;
        int max_h=0;
        for(int i=0;i<sizes.length;i++){
            // 더 긴 부분이 가로 길이가 된다.
            int v=Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min(sizes[i][0],sizes[i][1]);
            max_v=Math.max(max_v,v);
            max_h=Math.max(max_h,h);
        }
        answer=max_v*max_h;

        System.out.println("answer => " + answer);
    }
}
