package programmers.level1;

public class Gcd {
    /**
     * @DisplayName("최대공약수와 최소공배수")
     */
    public static void main(String[] args) {
        int n = 5;
        int m = 7;

        int max = Math.max(n, m);
        int min = Math.min(n, m);

        //최대 공약수
        //유클리드 호재법 알고리즘 => 최대공약수 구할 때 사용
        //2개의 자연수 a,b 에 대해서 a를 b로 나눈 나머지를 r 이라하면 (단,a>b) a와 b의 최대공약수는 b와 r의 최대공약수와 같다..
        while (min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }

        //최소 공배수 = 두수의 곱 / 최대공약수
        int gcd = n * m / max;

        System.out.println("max = " + max);
        System.out.println("gcd = " + gcd);

        int[] answer = {max, gcd};
        /**
         *     [재귀함수 사용하여 해결한 코드]
         *     public int[] gcdlcm(int a, int b) {
         *         int[] answer = new int[2];
         *
         *           answer[0] = gcd(a,b);
         *         answer[1] = (a*b)/answer[0];
         *         return answer;
         *     }
         *
         *    public static int gcd(int p, int q)
         *    {
         *     if (q == 0) return p;
         *     return gcd(q, p%q);
         *    }
         */
    }
}
