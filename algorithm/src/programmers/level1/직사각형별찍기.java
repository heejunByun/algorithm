package programmers.level1;

public class 직사각형별찍기 {
    /**
     * @DisplayName("직사각형 별찍기")
     */
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        String star = "";
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
