package programmers.level1;

public class minNumRemoveSuc {
    /**
     * @DisplayName("제일 작은 수 제거하기")
     */
    public static void main(String[] args) {
        //최소값 구하는 알고리즘 돌려서 원본 배열 중 가장 작은 수 index 값 가지고 그 index 를 제외하고 새로운 배열에다가 넣어줄 것
        int[] arr = {8, 4, 2, 5, 1};
        int[] answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        if (arr.length <= 1) {
            // answer[0] = -1; //이렇게하면 컴파일 오류남 -1이 확실한 지문이라면
            answer = new int[]{-1}; //이 코드로 지정할 것
        } else {
            for (int i : arr) {
                if (min > i) {
                    min = i;
                }
            }
            int idx = 0;
            for (int a : arr) {
                if (min != a) {
                    System.out.println("a = " + a);
                    answer[idx++] = a;
                }
            }
        }
    }
}
