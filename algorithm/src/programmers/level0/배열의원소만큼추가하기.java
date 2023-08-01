package programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class 배열의원소만큼추가하기 {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4};
        solution(arr);
    }

    private static int[] solution(int[] arr) {
        List<Integer> X = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = arr[i];
            for (int j = 0; j < count; j++) {
                X.add(count);
            }
        }

        int[] answer = new int[X.size()];
        for (int k = 0; k < X.size(); k++) {
            answer[k] = X.get(k);
            System.out.println("answer = " + answer[k]);
        }


        /**
         * 주의할 점은, toArray 메서드를 사용하더라도 기본적으로 Integer[] 배열로 반환되기 때문에
         * int[] 배열로 바로 변환할 수 없습니다.
         * 따라서 위의 예시 코드와 같이 수동으로 원소를 int로 변환하여 새로운 배열에 담아주어야 합니다.
         */

        return answer;
    }
}
