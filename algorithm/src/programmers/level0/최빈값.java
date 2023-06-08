package programmers.level0;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 최빈값 구하기
 * 문제 설명
 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
 * 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
 * 최빈값이 여러 개면 -1을 return 합니다.
 *
 * 제한사항
 * 0 < array의 길이 < 100
 * 0 ≤ array의 원소 < 1000
 * 입출력 예
 * array	result
 * [1, 2, 3, 3, 3, 4]	3
 * [1, 1, 2, 2]	-1
 * [1]	1
 */
public class 최빈값 {

    public static void main(String[] args) {
//        solution(new int[] {1, 2, 3, 3, 3, 4});
        solution(new int[]{1, 1, 2, 2,2});
    }

    private static void solution(int[] array) {
        // 1시간동안 못품
        Arrays.sort(array);
        int answer = 0;
        int max = 0;
        int maxNum = array[0];
        int cnt = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                cnt++;
                if (cnt > max) {
                    max = cnt;
                    maxNum = array[i];
                } else if (cnt == max) { // 이전의 최빈값과 일치하면 -1
                    maxNum = -1;
                }
            } else {
                cnt = 1;
            }
        }
    }

}
