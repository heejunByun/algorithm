package programmers.level2;

import java.util.Stack;

public class 올바른괄호 {
    /**
     * 문제 설명
     * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
     * <p>
     * "()()" 또는 "(())()" 는 올바른 괄호입니다.
     * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
     * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
     * 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     * <p>
     * 제한사항
     * 문자열 s의 길이 : 100,000 이하의 자연수
     * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
     * 입출력 예
     * s	answer
     * "()()"	true
     * "(())()"	true
     * ")()("	false
     * "(()("	false
     * 입출력 예 설명
     * 입출력 예 #1,2,3,4
     * 문제의 예시와 같습니다.
     *
     * @return
     */
    public static boolean main(String[] args) {
        /**
         * runtime 오류
         * stack 객체 사용해서 풀어야하는 문제
         */
        /**
         *
            //괄호가 왼쪽 괄호일 때 + 1
            //괄호가 오른쪽 괄호일 떄 - 1
            //int 가 0 이면 true 아니면 false
            //첫 문자가 ) 이면 false > 이후에 숫자계산
            // String s = "(())()";
            // String s = ")()(";
            String s = "(()(";
            boolean answer = true;
            int cnt = 0;

            StringBuilder sb = new StringBuilder();
            String[] arr = s.split("");
            if (")".equals(s.substring(0, 1))) { answer = false; }
            else {
                for (int i = 0; i < arr.length; i++) {
                    if ("(".equals(arr[i])) { cnt++; } else if (")".equals(arr[i])) { cnt--; }
                }
                System.out.println("cnt = " + cnt);
                if (cnt == 0) { answer = true; } else { answer = false; }
            }
            System.out.println("answer = " + answer);
         */
        // String s = "(())()";
        String s = ")()(";
        // String s = "(()(";
        Stack<Character> ch = new Stack<>();
        boolean answer = true;
        for (int i = 0; i < s.length(); i++) {
            if ("(".equals(s.charAt(i))) {
                ch.push('(');
            } else {
                if (ch.isEmpty()) {
                    return false;
                } else {
                    ch.pop();
                }
            }
        }
        System.out.println("1 = " + 1);
        answer = (ch.isEmpty()) ? true : false;
        System.out.println("2 = " + 2);
        System.out.println("answer = " + answer);

        //System.out.println(s.length());
        return answer;
    }
}
