package programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class 배열만들기2 {

    public static void main(String[] args) {
        solution(5, 555);
    }

    private static void solution(int l, int r) {
        String conStr;
        List<String> strList = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            int count = 0;
            conStr = String.valueOf(i);
            for (int k = 0; k < conStr.length(); k++) {
                if (conStr.charAt(k) == '5' || conStr.charAt(k) == '0') {
                    count++;
                }
            }

            if (count == conStr.length()) {
                strList.add(conStr);
            }
        }

        int[] answer = strList.stream().mapToInt(i -> Integer.parseInt(i)).toArray();
        int[] empty = {-1};
        if (answer.length == 0) answer = empty;
        for (int i : answer) {
            System.out.println("i = " + i);
        }

    }
}
