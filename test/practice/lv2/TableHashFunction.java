package practice.lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TableHashFunction {

    /*문제 설명
    완호가 관리하는 어떤 데이터베이스의 한 테이블은 모두 정수 타입인 컬럼들로 이루어져 있습니다. 테이블은 2차원 행렬로 표현할 수 있으며 열은 컬럼을 나타내고, 행은 튜플을 나타냅니다.
    첫 번째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지 않도록 보장됩니다. 완호는 이 테이블에 대한 해시 함수를 다음과 같이 정의하였습니다.

    해시 함수는 col, row_begin, row_end을 입력으로 받습니다.
    테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
    정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
    row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
    테이블의 데이터 data와 해시 함수에 대한 입력 col, row_begin, row_end이 주어졌을 때 테이블의 해시 값을 return 하도록 solution 함수를 완성해주세요.

    제한 사항
    1 ≤ data의 길이 ≤ 2,500
    1 ≤ data의 원소의 길이 ≤ 500
    1 ≤ data[i][j] ≤ 1,000,000
    data[i][j]는 i + 1 번째 튜플의 j + 1 번째 컬럼의 값을 의미합니다.
    1 ≤ col ≤ data의 원소의 길이
    1 ≤ row_begin ≤ row_end ≤ data의 길이*/

    int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
    int col = 2;
    int row_begin = 2;
    int row_end = 3;

    class Obj{
        int[] arr;

        Obj(int[] arr){
            this.arr = arr;
        }

        int[] getArr(){
            return this.arr;
        }
    }

    List<Obj> list = new ArrayList<>();

    void init(int[][] data){
        for (int[] datum : data) {
            list.add(new Obj(datum));
        }
    }

    @Test
    void tableHashFunction() {
        int answer = 0;

        //2차원 배열 인덱스, 값을 변수로 가진 객체 생성 후 List에 저장
        init(data);

        //정렬 기준
        Comparator<Obj> comparator = (o1, o2) -> {
            int[] arr1 = o1.getArr();
            int[] arr2 = o2.getArr();
            if(arr1[col-1] > arr2[col-1]){
                return 1;
            }
            else if(arr1[col-1] == arr2[col-1]){
                if(arr1[0] < arr2[0]){
                    return 1;
                }
            }
            return -1;
        };

        //정렬
        Collections.sort(list, comparator);

        for(int i = row_begin-1; i <= row_end-1; i++){
            int[] objArr = list.get(i).getArr();
            int sum = 0;
            for (int k : objArr) {
                sum += (k % (i + 1));
            }
            answer ^= sum;
        }

        System.out.println(answer);
    }
}