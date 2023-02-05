package programmers.level2;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        String s = "110010101001";
        solution(s);
    }

    public static int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int totalZero = 0;
        while (!"1".equals(s)) {
            cnt++;
            int[] result = bin(s);
            int i = result[1];
            s = Integer.toBinaryString(i);
            totalZero += result[0];
        }
        System.out.println("cnt = " + cnt);
        return new int[] {cnt, totalZero};
    }

    public static int[] bin(String a) {
        int zeroCount = 0;
        String temp = "";
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (ch == '0') { zeroCount++; }
            else if (ch == '1') { temp += ch; }
        }
        return new int[] {zeroCount, temp.length()};
    }
}
