package Algorithm;

import java.util.Arrays;

public class Permutation {

    static int[] res;

    static void permutation(int[] arr, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            return;
        }

        for (int i=depth; i < arr.length; i++) {
            swap(arr, depth, i);
            res[depth] = arr[depth];
            permutation(arr, depth + 1, r);
            swap(arr, depth, i);
        }
    }


    static void permutationByDfs(int[] arr, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                res[depth] = output[depth];
                permutationByDfs(arr, output, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int r = 3;  // 선택할 개수
        res = new int[r];   // 조합의 경우들이 담김

        // 재귀함수 + swap을 이용한 방법
        permutation(input, 0, r);

        System.out.println("----------------");

        // DFS를 이용한 방법
        int[] output = new int[input.length];
        boolean[] visited = new boolean[input.length];
        permutationByDfs(input, output, visited, 0, r);
    }
}
