package programmers.level2;


/**
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중
 * 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 */
public class 최댓값과최솟값 {

    public static void main(String[] args) {
        String s = "1 2 3 4";
        // String s = "1 -2 3 4";
        solution(s);
    }

    public static String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int tempA = 0;
        int tempB = 0;
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            tempA = Integer.parseInt(arr[i]);
            for (int j = 1; j < arr.length - 1; j++) {
                tempB = Integer.parseInt(arr[j]);
                max = Math.max(tempA, tempB);
                min = Math.min(tempA, tempB); //최소값을 이렇게 구하면 안됨
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        return answer;
    }

}
