package programmers.level2;

import java.util.Stack;

/**
 * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
 *
 * (), [], {} 는 모두 올바른 괄호 문자열입니다.
 * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
 * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
 * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
 * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * s의 길이는 1 이상 1,000 이하입니다.
 * 입출력 예
 * s	result
 * "[](){}"	3
 * "}]()[{"	2
 * "[)(]"	0
 * "}}}"	0
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 다음 표는 "[](){}" 를 회전시킨 모습을 나타낸 것입니다.
 * x	s를 왼쪽으로 x칸만큼 회전	올바른 괄호 문자열?
 * 0	"[](){}"	O
 * 1	"](){}["	X
 * 2	"(){}[]"	O
 * 3	"){}[]("	X
 * 4	"{}[]()"	O
 * 5	"}[](){"	X
 * 올바른 괄호 문자열이 되는 x가 3개이므로, 3을 return 해야 합니다.
 */
public class 괄호회전하기 {
    public static void main(String[] args) {
        String s = "[](){}";
        int answer = 0;

        // 지정된 문자가 괄호형태인지 먼저 확인
        System.out.println("isProper(s) = " + isProper(s));
        if (isProper(s)) {
            answer++;
        }

        for (int i = 1; i < s.length(); i++) {
            s = cycle(s);
            if (isProper(s)) {
                answer++;
            }
        }

        System.out.println("answer = " + answer);
    }

    private static boolean isProper(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') { //검증하는 char 이 괄호형태의 시작 문자이면 stack 에 push
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    switch (s.charAt(i)) {
                        case ']':
                            validationStack(stack, '[');
                            break;
                        case ')':
                            validationStack(stack, '(');
                            break;
                        case '}':
                            validationStack(stack, '{');
                            break;
                    }
                } else {
                    stack.push(s.charAt(i)); // stack 이 빈 공간이여도 {[( 괄호들을 stack 에 넣어준다.
                }
            }
        }

        return stack.isEmpty();
    }

    private static void validationStack(Stack<Character> stack, char ch) {
        if (stack.peek() == ch) { //들어간 문자열과, 인자값으로 들어온 문자열이 같으면 마지막 stack 항목 삭제
            stack.pop();
        }
    }

    //문자열을 왼쪽으로 움직이는 함수
    private static String cycle(String s) {
        return s = s.substring(1) + s.charAt(0);
    }

}
