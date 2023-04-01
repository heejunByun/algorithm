package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    static Set<Integer> set = new HashSet<>(); // 중복된 수를 방지하기 위한 Set

    public static void main(String[] args) {
        solution("17");
    }

    public static int solution(String numbers) {
        int answer = 0;
        int[] nums = new int[numbers.length()]; // 문자열을 숫자 배열로 변환하기 위한 배열
        for (int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) - '0'; // 문자를 숫자로 변환
        }

        for (int i = 1; i <= numbers.length(); i++) { // 종이 조각으로 만들 수 있는 수의 길이
            boolean[] visited = new boolean[numbers.length()]; // 조합을 위한 방문 체크 배열
            int[] temp = new int[i]; // 조합으로 만들어진 숫자를 담을 배열
            makeNumber(nums, visited, temp, 0, i); // 숫자 조합 생성
        }

        for (int num : set) { // 소수 판별
            if (isPrime(num)) {
                answer++;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    // 숫자 조합 생성
    private static void makeNumber(int[] nums, boolean[] visited, int[] temp, int depth, int length) {
        if (depth == length) {
            int num = 0;
            for (int i = 0; i < length; i++) {
                num += temp[i] * Math.pow(10, length - i - 1); // 조합으로 만들어진 숫자 생성
            }
            set.add(num); // Set에 추가
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = nums[i];
                makeNumber(nums, visited, temp, depth + 1, length);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
