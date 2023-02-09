package programmers.level2;

/**
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서,
 * n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
 *
 * 제한 사항
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 * 입출력 예
 * arr	        result
 * [2,6,8,14]	168
 * [1,2,3]	    6
 */
public class N개의최소공배수 {
    public static void main(String[] args) {
        solution(new int[] {2,6,8,14});
    }

    public static int solution(int[] arr) {
        int answer = 0;
        answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd; // answer 가 두 수의 비교하는 최소공배수가 된다.
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    //최대공약수 구하는 함수 (유클리드 호제법)
    public static int gcd(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        while(min != 0){
            int r = max % min;
            max = min;
            min = r;
        }
        return min;
    }
}
