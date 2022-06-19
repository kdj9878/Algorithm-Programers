package dataStructure;

public class DynamicProgramming {

    static long[] fiboArr;

    public static void main(String[] args) {
        long n = 100;
        // 일반적인 피보나치 수열 계산법
        //System.out.println(fibonachi(n));

        // DP(DynamicProgramming)을 사용한 피보나치 수열 계산법
        fiboArr = new long[(int) (n+1)];
        System.out.println(fibonachiByDp(n));
    }

    static long fibonachi(long n){
        if(n <= 2) return 1;
        return fibonachi(n-1) + fibonachi(n-2);
    }

    static long fibonachiByDp(long n){
        if(n <= 1) {
            return n;
        }
        // int 배열을 선언할 경우 빈 공간에 0이 들어가므로 0일 경우 데이터가 없는 상태
        else if(fiboArr[(int) n] == 0){
            return fiboArr[(int) n] = fibonachiByDp(n-1) + fibonachiByDp(n-2);
        }else{
            // 데이터가 이미 존재한다면 그 값을 바로 반환
            return fiboArr[(int) n];
        }
    }
}
