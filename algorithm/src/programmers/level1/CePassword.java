package programmers.level1;

public class CePassword {
    /**
     * @DisplayName("시저 암호")
     */
    public static void main(String[] args) {
        //알파벳 아스키 26를 나머지 값???
        //전혀 풀지 못하고 이해도 못함
        String s = "a B z";
        int n = 4;
        String answer = "";
        //아스키코드 48
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                System.out.println("ch  = " + (char) ((ch - 'a' + n) % 26 + 'a'));
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            answer += ch;
        }
        System.out.println("answer = " + answer);
    }
}
