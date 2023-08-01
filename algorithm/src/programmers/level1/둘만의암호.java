package programmers.level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.
 *
 * 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
 * index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
 * skip에 있는 알파벳은 제외하고 건너뜁니다.
 * 예를 들어 s = "aukks", skip = "wbqd", index = 5일 때,
 * a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다.
 * 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다.
 * 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.
 *
 * 두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때 위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.
 */
public class 둘만의암호 {

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        // solution(s, skip, index); // 런타임 오류남
        solutionRefer(s, skip, index);
    }

    private static String solutionRefer(String s, String skip, int index) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c += 1;
                if (c > 'z') { c -= 26; }

                // skip 에 있는 알파벳일 경우 j 를 하나 뺀다?
                // j를 하나 뻄으로서 j가 하나 뺀 수로 다시 for 문을 돌면서 치환값을 찾는다.. (까먹었으면 다시 디버킹 해볼 것)
                if (skip.contains(String.valueOf(c))) { j--; }
            }
            answer += c;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private static String solution(String s, String skip, int index) {
        String answer = "";

        // 알파벳을 만들기?
        List<Character> alpha = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ((char) 'a' + i);
            alpha.add(ch);
        }

        // 알파벳 빼기
        for (int i = 0; i < alpha.size(); i++) {
            for (int j = 0; j < skip.length(); j++) {
                char sk = skip.charAt(j);
                if (sk == alpha.get(i)) {
                    alpha.remove(i);
                }
            }
        }
        // 순서 찾아서 치환하기
        for (int j = 0; j < s.length(); j++) {
            char sCh = s.charAt(j);
            for (int i = 0; i < alpha.size(); i++) {
                char alCh = alpha.get(i);
                if (sCh == alCh) {
                    int k = (i + 5) % alpha.size();
                    answer += String.valueOf(alpha.get(k));
                }
            }
        }
        System.out.println("alpha = " + alpha);
        System.out.println("answer = " + answer);

        return answer;
    }

}
