package programmers.level1;

public class 최소직사각형 {
    /**
     * @DisplayName("최소 직사각형")
     * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
     * <p>
     * 명함 번호	가로 길이	세로 길이
     * 1	60	50
     * 2	30	70
     * 3	60	30
     * 4	80	40
     * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
     * 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
     * <p>
     * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때,
     * 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
     * [문제 해결법]
     * 어렵게 생각할 거 없이 주어지는 명함마다 큰 수와 작은 수를 분류해서, 큰 수는 큰 수끼리 작은 수는 작은 수끼리 비교한 것 중 가장 큰 값을 각각 뽑은뒤 곱해주면 된다!
     */
    public static void main(String[] args) {
        //문제 이해가기 어려움
        int[][] size = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int answer = 0;
        int max_a = 0;
        int min_a = 0;

        for (int i = 0; i < size.length; i++) {
            int mav = Math.max(size[i][0], size[i][1]);
            int miv = Math.min(size[i][0], size[i][1]);
            max_a = Math.max(max_a, mav);
            min_a = Math.max(min_a, miv);
        }
        System.out.println("max_a = " + max_a);
        System.out.println("min_a = " + min_a);

        answer = max_a * min_a;
        System.out.println("answer = " + answer);
    }
}
