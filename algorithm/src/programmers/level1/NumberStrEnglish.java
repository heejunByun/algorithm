package programmers.level1;

import java.util.HashMap;

public class NumberStrEnglish {
    /**
     * @DisplayName("숫자 문자열과 영단어")
     */
    public static void main(String[] args) {
        String s = "one4seveneight";
        //String s = "23four5six7";
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        System.out.println("map.keySet() = " + map.keySet());

        for (String key : map.keySet()) {
            if (s.contains(key)) {
                System.out.println("key = " + key);
                s = s.replace(key, String.valueOf(map.get(key)));
            }
            ;
        }
        answer = Integer.parseInt(s);

        System.out.println("s = " + s);
        System.out.println("answer = " + answer);
    }
}
