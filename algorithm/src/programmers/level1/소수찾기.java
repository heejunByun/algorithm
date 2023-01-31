package programmers.level1;

public class 소수찾기 {
    public static void main(String[] args) {
        //효율성에서 탈락
        //break 가 있어야되는 거 같음
        //에라토스테네스의 체
        int n = 10;
        int answer = 0;
        boolean bol = false;

        for (int i = 2; i <= n; i++) {
            bol = sosu(i);
            if (!bol) {
                answer++;
            }
        }
        System.out.println("answer = " + answer);

        // System.out.println("Math.sqrt(4) = " + Math.sqrt(4));
        // 구글링 해서 나온 답
        answer = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) { //에라토스테네서의 체
                if (i % j == 0) { //나누어떨어지면 소수X
                    flag = false; //falg를 false로 바꿔서 소수가 아니라고 체크
                    break; //break를 안해주면 효율성 테스트 통과 못함
                }
            }
            if (flag == true) //소수인 숫자는 flag가 변하지 않고 true
                answer++;
        }

        System.out.println("answer = " + answer);
    }

    public static boolean sosu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }

}
