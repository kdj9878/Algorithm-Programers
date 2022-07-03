package bruteForce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DecimalSearch {

    /*문제 설명
    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

    각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.*/

    /*제한사항
    numbers는 길이 1 이상 7 이하인 문자열입니다.
    numbers는 0~9까지 숫자만으로 이루어져 있습니다.
    "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
    11과 011은 같은 숫자로 취급합니다.
    */

    /*
    순열 구하는 알고리즘 참고 사이트
    https://m.blog.naver.com/PostView.nhn?isHttpsRedirect=true&blogId=ssang8417&logNo=222147007019
     */

    /*
    문제 해결
    주어진 숫자에 대해 순열을 구해주고 해당 순열의 요소들에 대해 소수인지 판별
     */

    int[] res;

    Set<Integer> resSet = new HashSet<>();

    // 순열 구하는 함수
    void permutation(int[] arr, int depth, int r){
        if(depth == r){
            int toInt = intArrToInt(res);
            resSet.add(toInt);
            return;
        }

        for(int i = depth; i < arr.length; i++){
            swap(arr, depth, i);
            res[depth] = arr[depth];
            permutation(arr, depth+1, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    int intArrToInt(int[] res){
        int num = 0;
        for(int digit: res) {
            num *= 10; num += digit;
        }
        return num;
    }

    // 소수 판별
    boolean isPrime(int x) {
        for (int i=2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    @ParameterizedTest
    @ValueSource(strings = {"17", "123", "011", "121"})
    @DisplayName("소수 찾기")
    void decimalSearch(String numbers){
        int answer = 0;

        // String 문자열을 int배열로 변환
        int[] intArr = Stream.of(numbers.split("")).mapToInt(Integer::parseInt).toArray();

        // 1부터 numbers의 길이만큼 차례대로 선택
        for(int i = 1; i <= numbers.length(); i++){
            res = new int[i]; // 찾을 요소의 길이
            permutation(intArr, 0, i);
        }

        answer = (int) resSet.stream().filter(x -> isPrime(x) && x != 1 && x != 0).count();

        System.out.println(answer);
    }
}
