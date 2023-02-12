package programmers.level2;

public class 피보나치수 {

    static int[] dp = new int[100001]; //전역변수로

    public static void main(String[] args) {
        int answer = 0;
        answer = fibo(43);
        System.out.println("answer = " + answer);
    }

    public static int fibo(int n) {
        //int[] dp = new int[n + 1]; //배열 선언하는 것도 전역변수로 선언해야 런타임 오류가 안남
        if (n < 2) return n;
        //dp 핵심
        if (dp[n] != 0) return dp[n] % 1234567; // 이미 계산된 값이 있으면 바로 리턴을 해준다
        dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567; //DP & 재귀함수
        return dp[n];
    }

}
