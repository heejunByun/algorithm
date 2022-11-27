package programmers.level1;

import java.util.Arrays;

/**
 * @DisplayName("정수 내림차순으로 배치하기")
 */
public class IntSort {
    public static void main(String[] args) {
        long n = 118372;
        String str = String.valueOf(n);
        String[] aryStr = str.split("");
        Arrays.sort(aryStr); //오름차순
        StringBuilder sb = new StringBuilder();
        for (String aList : aryStr) {
            // System.out.println("aList = " + aList);
            sb.append(aList);
            // System.out.println("sb = " + sb);
        }
        long answer = Long.parseLong(String.valueOf(sb.reverse())); // reverse 뒤집기
        //873211
        System.out.println("answer = " + answer);
    }
}
