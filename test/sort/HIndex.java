package sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HIndex {

    /*문제 설명
    H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
    어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

    어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

    어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.*/

    /*제한사항
    과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
    논문별 인용 횟수는 0회 이상 10,000회 이하입니다.*/

    static int[] citations = {3, 0, 6, 1, 5};

    // 내가 작성한 풀이
    @Test
    @DisplayName("H - Index")
    void hIndex(){
        int answer = 0;
        int max = 0;

        // 최대 인용 횟수
        for(int i = 0; i < citations.length; i++){
            if(max < citations[i]){
                max = citations[i];
            }
        }

        int h = 1;
        // 최대 인용 논문까지 확인해야하므로 max + 1까지
        while(h != max+1){
            int count = 0;
            int less = 0;

            for(int j = 0; j < citations.length; j++){
                // h편 이상일 경우 증가
                if(h <= citations[j]){
                    count++;
                }
                // h편 이하일 경우 증가
                else if(h <= citations[j]){
                    less++;
                }
            }

            // h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용되었을 때
            // h가 가장 큰 수를 answer에 저장
            if(h <= count && h >= less && answer < h){
                answer = h;
            }

            h++;
        }

        System.out.println("answer => " + answer);
    }

    @Test
    @DisplayName("H - index 다른 사람 풀이....")
    void hIndexOthers(){
        /*
        * 원소 값은 점점 감소하고, 원소 값 이상인 것의 개수는 점점 감소하므로... 이 두 값의 최소값의 변화가 증가하다가 감소하는 지점을 찾는다...?
        * 이걸 어떻게 찾은거야
        * 천재세요?
        * */
        Arrays.sort(citations);
        System.out.println("citations => " + Arrays.toString(citations));
        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        System.out.println("answer =>" + max);
    }
}
