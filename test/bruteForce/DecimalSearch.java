package bruteForce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DecimalSearch {

    int[] res;

    Set<Integer> resSet = new HashSet<>();

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
    @ValueSource(strings = {"17", "011", "121"})
    @DisplayName("소수 찾기")
    void decimalSearch(String numbers){
        int answer = 0;

        // String 문자열을 int배열로 변환
        int[] intArr = Stream.of(numbers.split("")).mapToInt(Integer::parseInt).toArray();

        // 1부터 numbers의 길이만큼 차례대로 선택
        for(int i = 1; i <= numbers.length(); i++){
            res = new int[i];
            permutation(intArr, 0, i);
        }

        answer = (int) resSet.stream().filter(x -> isPrime(x) && x != 1 && x != 0).count();

        System.out.println(answer);
    }
}
