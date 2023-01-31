package programmers.level1;

/**
 * @DisplayName("자연수 뒤집어 배열로 만들기")
 */
public class 자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
        long n = 12345;
        String sn = Long.toString(n);
        int[] answer = new int[sn.length()]; // int[] answer = new int[5];
        int j = 0;
        for (int i = sn.length() - 1; i >= 0; i--) {
            char k = sn.charAt(i);
            System.out.println((int) k);
            answer[j++] = (int) k - 48; //charAt(문자열 숫자)를 int 로 형변환 하면 아스키코드로 형변환 된다.. -48 꼭 해줄 것
        }

        for (int h = 0; h < answer.length; h++) {
            System.out.println("answer[h] = " + answer[h]);
        }
    }
}
