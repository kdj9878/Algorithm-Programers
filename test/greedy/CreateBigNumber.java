package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class CreateBigNumber {

    /**
     * 1)가장 큰 수를 기준으로 앞에 있는 숫자들 중 가장 작은 수를 제거
     * 2)앞에 있는 숫자 제거 후 k번만큼 제거하지 못하였을 경우 가장 큰 수의 뒤에 있는 숫자 중 가장 작은 수부터 제거
     */

    String number = "88888";
    int k = 3;

    /**
     * StringBuffer를 활용한 풀이(미통과)
     * 시간초과 및 테스트케이스 실패
     */
    @Test
    void createBigNumber(){
        StringBuffer appendBf = new StringBuffer();
        int deleteCnt = 0;
        StringBuffer bf = new StringBuffer(number);
        int[] arr = Stream.of(bf.toString().split("")).mapToInt(Integer::parseInt).toArray();

        //가장 큰 수와 인덱스 구하기
        int max = -1; //가장 큰 수
        int maxIdx = 0;//가장 큰 수의 인덱스
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                maxIdx = i;
            }
        }

        //가장 큰 수가 앞에 있을 경우에는 패스
        if(maxIdx != 0){
            //가장 큰 수의 앞 부분 자르기
            StringBuffer nextToBigNumber = new StringBuffer(bf.substring(0, maxIdx));

            while(deleteCnt < k && nextToBigNumber.length() > 0){
                int min = 9;
                int minIdx = -1;
                //자른 부분에서 가장 작은 숫자들 제거
                for(int j = 0; j < nextToBigNumber.toString().length(); j++){
                    if(Integer.parseInt(nextToBigNumber.substring(j, j+1)) < min){
                        min = Integer.parseInt(nextToBigNumber.substring(j, j+1));
                        minIdx = j;
                    }
                }

                nextToBigNumber.deleteCharAt(minIdx);
                deleteCnt++;
            }

            appendBf.append(nextToBigNumber);
        }


        //k만큼 전부 제거하지 않았을 경우 가장 큰 수의 뒤에서부터 작은 수들 검색 후 삭제
        if(deleteCnt < k){
            StringBuffer behindBigNumber = new StringBuffer(bf.substring(maxIdx, number.length()));
            while(deleteCnt < k && behindBigNumber.length() > 0){
                int min = 9;
                int minIdx = 0;
                //자른 부분에서 가장 작은 숫자들 제거
                for(int j = 0; j < behindBigNumber.toString().length(); j++){
                    if(Integer.parseInt(behindBigNumber.substring(j, j+1)) < min && Integer.parseInt(behindBigNumber.substring(j, j+1)) != max){
                        min = Integer.parseInt(behindBigNumber.substring(j, j+1));
                        minIdx = j;
                    }
                }

                behindBigNumber.deleteCharAt(minIdx);
                deleteCnt++;

            }
            appendBf.append(behindBigNumber);
        }
        else{
            //전부 제거 했을 경우
            appendBf.append(bf.substring(maxIdx, number.length()));
        }

        Assertions.assertEquals("88", appendBf.toString());
    }

    @Test
    void createBigNumberByCombination(){

    }
}
