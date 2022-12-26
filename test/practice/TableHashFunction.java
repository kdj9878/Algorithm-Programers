package practice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TableHashFunction {

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
