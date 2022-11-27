package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class StringSortReverse {
    /**
     * @DisplayName("문자열 내림차순으로 배치하기")
     */
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String answer = "";
        char[] chr = s.toCharArray();
        ArrayList<Character> listChr = new ArrayList<Character>();
        for (char a : chr) {
            listChr.add(a);
        }
        Collections.sort(listChr, Collections.reverseOrder());
        for (char a : listChr) {
            answer += a;
        }
        System.out.println("answer = " + answer);
        /**
         *     [다른사람풀이 StringBuilder]
         *     char[] sol = str.toCharArray();
         *     Arrays.sort(sol);
         *     return new StringBuilder(new String(sol)).reverse().toString();
         *
         *     [다른사람풀이2 StringBuffer]
         *     char[] ch = str.toCharArray();
         *     Arrays.sort(ch);
         *     StringBuffer st = new StringBuffer(String.valueOf(ch));
         *     st.reverse();
         *
         *     하나의 작업만 처리하는 클래스라면 StringBuffer 보단 StringBuilder 가 더 빠름
         */
    }
}
