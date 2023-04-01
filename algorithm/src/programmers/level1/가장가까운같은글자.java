package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
 * 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
 * <p>
 * b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 * a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
 * n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
 * a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
 * 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
 * <p>
 * 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
 * <p>
 * 제한사항
 * 1 ≤ s의 길이 ≤ 10,000
 * s은 영어 소문자로만 이루어져 있습니다.
 * 입출력 예
 * s	result
 * "banana"	[-1, -1, -1, 2, 2, 2]
 * "foobar"	[-1, -1, 1, -1, -1, -1]
 */
public class 가장가까운같은글자 {


    public static void main(String[] args) {
        stringFirstEqual sfe = new stringFirstEqual();
        System.out.println("sfe.solution() = " + sfe.solution("banana"));
        System.out.println("sfe.solution() = " + sfe.solution("foobar"));
    }
}

class stringFirstEqual {
    public int[] solution(String s) {

        /**
         * indexOf 를 lastIndexOf 으로 못바꾸고 몰라서 못품
         *         int[] answer = new int[s.length()];
         *         String tempStr = "";
         *         Arrays.fill(answer, -1);
         *         for (int i = 0; i < s.length(); i++) {
         *             char ch = s.charAt(i);
         *             if (tempStr.contains(String.valueOf(ch))) {
         *                 int index = tempStr.lastIndexOf(String.valueOf(ch));
         *                 int ar = i - index;
         *                 answer[i] = ar;
         *             }
         *             tempStr = tempStr + String.valueOf(ch);
         *         }
         */

        //구글링 버전
        // b a n a n a
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                answer[i] = i - index;
            }
            map.put(ch, i);
            System.out.println("map = " + map);
        }
        return answer;
    }
}
