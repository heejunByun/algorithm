package programmers.level2;

import java.util.*;

/**
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
 * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 사항
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 * 입출력 예
 * progresses	speeds	return
 * [93, 30, 55]	[1, 30, 5]	[2, 1]
 * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 * 입출력 예 설명
 * 입출력 예 #1
 * 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
 * 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
 * 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
 * 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 *
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 */
public class 기능개발 {

    public static void main(String[] args) {
        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        // solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        //각 기능마다 100%가 되는 날짜를 카운트해서 큐에 넣어준다
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int day = 0;
            while (progress < 100) {
                progress += speed;
                day++;
            }
            queue.offer(day);
        }
        System.out.println("queue = " + queue);
        int result = 0;
        int que = 0;
        while (!queue.isEmpty()) {
            if (que >= queue.peek()) { // 뽑힌 큐값과 그 다음 큐값을 비교해서 다음 큐 값이 작을경우 그냥 poll 하고 넘어간다
                queue.poll();
            } else {
                que = queue.poll(); // 비교 큐값 교체
            }
            System.out.println("que = " + que);
            result++;
            System.out.println("result = " + result);
            if (queue.isEmpty()) { //마지막 값
                ans.add(result);
            } else if (queue.peek() > que) { // 큐의 그 다음값이 큰 경우에만 넣어준다.
                ans.add(result);
                que = 0;
                result = 0;
            }
        }
        System.out.println("ans = " + ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
