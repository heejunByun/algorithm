package programmers.level2;

/**
 * n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * 각 숫자는 1 이상 50 이하인 자연수입니다.
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 * 입출력 예
 * numbers	target	return
 * [1, 1, 1, 1, 1]	3	5
 * [4, 1, 2, 1]	4	2
 */
public class 타겟넘버 {
    public static void main(String[] args) {
        //너무 어려움
        targetNumber tn = new targetNumber();
        //DFS,BFS
         System.out.println("targetNumber : " + tn.solution(new int[] {1,1,1,1,1}, 3));
//        System.out.println("targetNumber : " + tn.solution(new int[] {4,1,2,1}, 2));
    }
}

class targetNumber {
    private static int answer;

    public int solution(int[] numbers, int target) {
        //너무 어렵다 그려도 해보고 디버깅 해봐도 이해가 안된다
        //dfs를 호출하는 콜스택이 쌓이면서 + dfs 함수가 return이 되면 그 - dfs 함수가 실행이 되는것이다.
        dfs(0, 0, numbers, target);
        return answer;
    }

    void dfs(int n, int sum, int[] numbers, int target) {
        // 1. 탈출조건
        if (n == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        // 2. 수행조건
        dfs(n + 1, sum + numbers[n], numbers, target);
        dfs(n + 1, sum - numbers[n], numbers, target);
    }
}
