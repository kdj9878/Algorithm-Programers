package practice;

import org.junit.jupiter.api.Test;

public class ThreeMusketeers {

    int count = 0;

    public void combination(int[] arr, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }

            if(sum == 0){
                count++;
            }
            return;
        }
        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

    @Test
    void threeMusketeers(){
        int answer = 0;
        int[] arr = {1, 2, 3};
        int r = 3;
        combination(arr, new boolean[arr.length], 0, 0, r);
        answer = count;
        System.out.println(answer);
    }
}
