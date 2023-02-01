package programmers.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class JadenCase문자열만들기{
    /**
     * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
     * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
     * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
     */
    public static void main(String[] args) throws IOException {
        String s = "3people unFollowed me";

        /**
         * 런타임 오류 및 실패 코드
        String ary[] = s.split(" ");
        String answer = "";
        for (String str : ary) {
            System.out.println("str = " + str);
            System.out.println("str.substring(0, 1) = " + str.substring(0, 1));
            System.out.println("str.substring(0, 1).toUpperCase() = " + str.substring(0, 1).toUpperCase());

            if (str.length() == 0) {
                answer += " ";
            } else {
                str = str.replace(str.substring(0, 1), str.substring(0, 1).toUpperCase());
                str = str.replace(str.substring(1, str.length() - 1),  str.substring(1, str.length() - 1).toLowerCase());
                System.out.println("str after = " + str);
                answer += str + " ";
            }
        }
        answer = answer.substring(0, answer.length() - 1);
        System.out.println("answer = " + answer);
        */

        //Char 관련 문자 나올 때 StringBuilder 쓸 것
        StringBuilder sb = new StringBuilder();
        String[] arr = s.toLowerCase().split(" ");
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];

            if (str.length() == 0) {
               sb.append(" ");
               continue;
            }

            sb.append(str.substring(0,1).toUpperCase()); //첫 문자
            sb.append(str.substring(1, str.length())); //첫 문자부터 끝까지
            sb.append(" ");
        }

        if(!" ".equals(s.substring(s.length() - 1, s.length()))) { //마지막 문자
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }

        answer = sb.toString();
        System.out.println("answer = " + answer);


    }
}
