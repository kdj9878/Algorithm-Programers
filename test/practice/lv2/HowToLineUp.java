package practice.lv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class HowToLineUp {

    /**
     * 줄 서는 방법
     * https://school.programmers.co.kr/learn/courses/30/lessons/12936?language=java
     */

    /*문제 설명
    n명의 사람이 일렬로 줄을 서고 있습니다. n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다.
    n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다.
    예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.

        [1, 2, 3]
        [1, 3, 2]
        [2, 1, 3]
        [2, 3, 1]
        [3, 1, 2]
        [3, 2, 1]
    사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을
    return하는 solution 함수를 완성해주세요.*/

    /*제한사항
    n은 20이하의 자연수 입니다.
    k는 n! 이하의 자연수 입니다.*/

    ArrayList<Integer> list = new ArrayList<>();

    @Test
    @DisplayName("줄 서는 방법")
    void howToLineUp(){
        int n = 4;
        int k = 8;

        long permutation = 1;

        for(int i = 1; i <= n; i++) {
            list.add(i);
            permutation *= i;
        }
        int[] answer = new int[n];

        k--;

        int idx = 0;
        while(n > 0){
            permutation /= n;
            answer[idx++] = list.get((int) (k / permutation));
            list.remove((int) (k / permutation));
            k %= permutation;
            n--;
        }

        System.out.println(Arrays.toString(answer));

    }
}