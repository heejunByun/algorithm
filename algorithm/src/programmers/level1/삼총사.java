package programmers.level1;

public class 삼총사 {
    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) { //for 문 시작지점과 끝지점 확인 꼭 해라
            for (int j = i + 1; j < number.length - 1; j++) { //for 문 시작지점과 끝지점 확인 꼭 해라
                for (int k = j + 1; k < number.length; k++) { //for 문 시작지점과 끝지점 확인 꼭 해라
                    if (number[i] + number[j] + number[k] == 0) {
                        System.out.println("[i]: " + i + " number[i] = " + number[i] + " [j]: " + j + " number[j] = " + number[j] + " [k]: " + k + " number[k] = " + number[k]);
                        answer++;
                    }
                }
            }
        }

        System.out.println("answer = " + answer);
    }
}
