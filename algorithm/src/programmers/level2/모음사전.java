package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모음사전 {

    private static char[] words = {'A', 'E', 'I', 'O', 'U'};
    private static int max_length = 5;

    public static void main(String[] args) {
        solution("AAAAE");
    }

    public static int solution(String word) {
        int answer = 0;
        List<String> elements = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            dfs(elements, String.valueOf(words[i]));
        }

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void dfs(List<String> elements, String str) {
        if (str.length() > max_length) return;
        if (!elements.contains(str)) elements.add(str);
        for (int i = 0; i < words.length; i++) {
            dfs(elements, str + words[i]);
        }
    }
}
