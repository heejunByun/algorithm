package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;


public class 문자열내마음대로정렬하기 {
    /**
     * @DisplayName("문자열 내 마음대로 정렬하기")
     */
    public static void main(String[] args) {
        //어려움 생각 다시 해봐야할 듯
        //2시간동안 못풀다가 구글링에 찾아서 품 -> 생각차이...
        int n = 1;
        //String[] strings = {"sun", "bed", "car"};
        String[] strings = {"abce", "abcd", "cdx"};
        String[] answer = new String[strings.length];
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1, list.get(i).length());
        }

        for (String str : answer) {
            System.out.println("str = " + str);
        }
    }
}
