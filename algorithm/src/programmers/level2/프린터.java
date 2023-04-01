package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 *
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 *
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
 *
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
 * 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
 * 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
 * location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
 * 입출력 예
 * priorities	location	return
 * [2, 1, 3, 2]	2	1
 * [1, 1, 9, 1, 1, 1]	0	5
 * 입출력 예 설명
 * 예제 #1
 *
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 *
 * 6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
 */
public class 프린터 {
    public static void main(String[] args) {
        printSol sol = new printSol();
        System.out.println("sol 1 = " + sol.solution(new int[] {2,1,3,2}, 2));
//        System.out.println("sol 2 = " + sol.solution(new int[] {1,1,9,1,1,}, 0));
    }
}

class printSol {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]); // 우선순위 큐에 모든 요소를 넣음
        }
        Arrays.sort(priorities); // 우선순위를 기준으로 오름차순 정렬

        int idx = priorities.length - 1; // 우선순위가 가장 높은 문서의 인덱스
        while (!queue.isEmpty()) {
            int curr = queue.poll(); // 가장 앞에 있는 요소를 꺼냄
            if (curr == priorities[idx]) { // 우선순위가 가장 높은 문서를 발견한 경우
                idx--; // 다음으로 우선순위가 높은 문서를 찾기 위해 인덱스를 감소시킴
                answer++; // 출력된 문서의 수를 증가시킴
                if (location == 0) { // 내가 요청한 문서인 경우 반복문을 종료하고 출력된 문서의 수를 반환
                    break;
                } else {
                    location--; // 내가 요청한 문서가 아닌 경우 다음 문서로 이동
                }
            } else {
                queue.offer(curr); // 우선순위가 낮은 문서인 경우 큐의 가장 뒤에 추가
                if (location == 0) { // 내가 요청한 문서의 위치가 변경됨
                    location = queue.size() - 1; // 큐의 가장 뒤쪽으로 이동
                } else {
                    location--; // 내가 요청한 문서가 아닌 경우 다음 문서로 이동
                }
            }
        }
        return answer;
    }
}

class SolutionTest {
    // 블럭이 움직이지 않도록 접착시키는 메서드
    private void stick(int[][] map, int x, int y) {
        // 상하좌우를 체크하여 1인 블럭들을 2로 변경
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열의 범위를 벗어나거나 이미 접착된 블럭일 경우 continue
            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == 2) {
                continue;
            }

            // 상하좌우 중 1인 블럭을 2로 변경하고 해당 블럭을 기준으로 재귀호출
            if (map[nx][ny] == 1) {
                map[nx][ny] = 2;
                stick(map, nx, ny);
            }
        }
    }

    public int[][] solution(int[][] map) {
        int n = map.length; // 배열의 세로 길이
        int m = map[0].length; // 배열의 가로 길이

        // 매 초마다 블럭이 아래로 떨어지는 작업
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                // 1인 블럭일 경우
                if (map[i][j] == 1) {
                    int k = i;
                    // 아래쪽으로 1이 아닌 블럭이나 배열의 끝까지 이동
                    while (k < n - 1 && map[k+1][j] == 0) {
                        k++;
                    }
                    // 해당 블럭이 배열의 끝까지 이동한 경우
                    if (k == n - 1) {
                        map[i][j] = 0;
                        continue;
                    }
                    // 해당 블럭이 이동한 위치에 2인 블럭이 있는 경우
                    if (map[k+1][j] == 2) {
                        // 해당 블럭을 2로 변경하고 이동한 위치로 재귀호출하여 접착시키기
                        map[i][j] = 2;
                        stick(map, k+1, j);
                    } else {
                        // 이동한 위치에 빈 공간이 있을 경우 해당 블럭을 이동시키기
                        map[k][j] = map[i][j];
                        map[i][j] = 0;
                    }
                }
            }
        }

        return map;
    }
}