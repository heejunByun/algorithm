package programmers.level2;

/**
 * 그림을 그리면서 규칙을 찾았습니다.
 *
 * 노란 타일을 감싸기 위해서는 반드시 가로,세로 모두 동일하게 (브라운 - 옐로우 - 브라운 )순서로 진행되야 합니다.
 * 즉 옐로우 타일 + 2개의 브라운 타일이 붙어야 합니다.
 * 옐로우 타일을 어떻게 배치해야할지 생각해야 합니다.
 * 배치하는 방법은 옐로우 타일의 약수입니다. ex)12 = (1,12), (2,6), (3,4)
 * 조건으로 가로길이 >= 세로길이 입니다.
 * 브라운 + 옐로우는 총 타일의 크기입니다.
 * 위의 규칙을 적용하여 풀어보면
 * find 라는 함수의 파라미터로 옐로우와 총 카펫 크기를 전달합니다.
 * find 함수는 옐로우의 약수를 먼저 찾습니다.
 * 약수 조건이 맞을 때 2번 조건인 +2 을 각각 더하고 곱해서 전달한 sum 이랑 같으면 정답입니다.
 *
 * 저는 y = 세로 길이, x = 가로 길이로 따지니 이 부분 주의 부탁드립니다.
 * 아래 답이 있습니다
 */
public class 카펫 {
    public static void main(String[] args) {
        solution(10, 2);
//        solution(24, 24);
    }
    public static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        return find(yellow, sum);
    }
    // 개념을 도출하기가 너무 어려움
    // 풀이법 보고 풀었음
    public static int[] find(int yellow, int sum) {
        int x = 0, y = 0; //x가로 , y세로 가로 >= 세로

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                System.out.println("i = " + i);
                x = Math.min(i, yellow / i);
                y = Math.max(i, yellow / i);
                if ((x + 2) * (y + 2) == sum) {
                    break;
                }
            }
        }
        System.out.println("y = " +  (y + 2) + "  x = " + (x + 2));
        return new int[] {y + 2 , x + 2};
    }
}
