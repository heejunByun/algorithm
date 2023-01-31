package programmers.level1;

public class 삼진법뒤집기 {
    /**
     * @DisplayName("3진법 뒤집기")
     */
    public static void main(String[] args) {
//        String binaryString = Integer.toBinaryString(i); //2수
//        String octalString = Integer.toOctalString(i);   //8진수
//        String hexString = Integer.toHexString(i);       //16진수

//        int binaryToDecimal = Integer.parseInt(binaryString, 2); // 2진수 -> 10진수
//        int binaryToOctal = Integer.parseInt(octalString, 8); // 8진수 -> 10진수
//        int binaryToHex = Integer.parseInt(hexString, 16); // 16진수 -> 10진수
        int n = 125;
        String strN = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(strN);
        strN = sb.reverse().toString();
        int answer = 0;
        answer = Integer.parseInt(strN, 3);
        System.out.println("answer = " + answer);
    }
}
