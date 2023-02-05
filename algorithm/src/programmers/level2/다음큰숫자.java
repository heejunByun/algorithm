package programmers.level2;

/**
 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 *
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 *
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 *
 * 제한 사항
 * n은 1,000,000 이하의 자연수 입니다.
 * 입출력 예
 * n	result
 * 78	83
 * 15	23
 */
public class 다음큰숫자 {
    public static void main(String[] args) {

        int n = 15;
        // 1001110
        // 1010011
        String s = Integer.toBinaryString(n); //이진법으로 변환
        int answer = 0;
        int A = countStr(s, '1'); // 이진법 중 '1' 갯수 반환
        for (int i = n + 1; i < 10000000; i++) {
            String nextNum = Integer.toBinaryString(i); // 입력값부터 하나씩 증가하며 이진법 변환
            int B = countStr(nextNum, '1'); // 증가한 이진법 중 '1' 갯수 반환
            if (A == B) { // 1의 갯수가 맞으면 결과값 리턴 후 for 문 종료
                answer = Integer.parseInt(nextNum, 2);
                break;
            }
        }

        System.out.println("answer = " + answer);
    }

    public static int countStr(String s, char ch) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                cnt++;
            }
        }
        return cnt;
    }
}
