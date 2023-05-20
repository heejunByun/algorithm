package programmers.level0;

/**
 * 등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
 *
 * 제한사항
 * 2 < common의 길이 < 1,000
 * -1,000 < common의 원소 < 2,000
 * common의 원소는 모두 정수입니다.
 * 등차수열 혹은 등비수열이 아닌 경우는 없습니다.
 * 등비수열인 경우 공비는 0이 아닌 정수입니다.
 * 입출력 예
 * common	result
 * [1, 2, 3, 4]	5
 * [2, 4, 8]	16
 */
public class 다음에올숫자 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4});
        solution(new int[]{2, 4, 8,});
    }

    public static int solution(int[] common) {
        int answer = 0;
        int length = common.length;
        int sumGap = common[length - 1] - common[length - 2];
        int multiplyGap = common[length - 1] / common[length - 2];

        if (common[length - 2] - common[length - 3] == sumGap) {
            //두 수의 차가 같으면 등차수열
            answer = common[length - 1] + sumGap;
        } else {
            //두 수의 차가 다르면 등비수열
            answer = common[length - 1] * multiplyGap;
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}
