package programmers.level1;

public class HideOnPhoneNumber {

    /**
     * @DisplayName("핸드폰 번호 가리기")
     */
    public static void main(String[] args) {
        String phoneNumber = "01033334444";
        String answer = "";
        int idx = phoneNumber.length() - 4;
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (i < idx) {
                answer += "*";
            } else if (i >= idx) {
                answer += String.valueOf(phoneNumber.charAt(i));
            }
        }
        // *******4444
        System.out.println("answer = " + answer);
    }
}
