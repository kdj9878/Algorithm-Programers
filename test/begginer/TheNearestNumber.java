package begginer;

import org.junit.jupiter.api.Test;

public class TheNearestNumber {

    /**
     * 가까운 수
     * https://school.programmers.co.kr/learn/courses/30/lessons/120890
     */

    /*문제 설명
    정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

    제한사항
    1 ≤ array의 길이 ≤ 100
    1 ≤ array의 원소 ≤ 100
    1 ≤ n ≤ 100
    가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.*/

    int[] array = {3, 10, 28};
    int n = 20;

    @Test
    void theNearestNumber(){
        int answer = 0;
        int tmp = 100;
        for(int i = 0; i < array.length; i++){
            int cha = Math.abs(n - array[i]);
            if(cha < tmp){
                tmp = cha;
                answer = array[i];
            }
            else if(cha == tmp){
                answer = answer < array[i] ? answer : array[i];
            }
        }
        System.out.println(answer);
    }
}
