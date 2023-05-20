package programmers.level0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문제 설명
 * 0번부터 n - 1번까지 n명의 학생 중 3명을 선발하는 전국 대회 선발 고사를 보았습니다.
 * 높은 3명을 선발해야 하지만, 개인 사정으로 전국 대회에 참여하지 못하는 학생들이 있어 참여가 가능한 학생 중 등수가 높은 3명을 선발하기로 했습니다.
 *
 * 각 학생들의 선발 고사 등수를 담은 정수 배열 rank와 전국 대회 참여 가능 여부가 담긴 boolean 배열 attendance가 매개변수로 주어집니다.
 * 전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 a, b, c번이라고 할 때 10000 × a + 100 × b + c를 return 하는 solution 함수를 작성해 주세요.
 *
 * 제한사항
 * 3 ≤ rank의 길이 = attendance의 길이 ≤ 100
 * rank[i]는 i번 학생의 선발 고사 등수를 의미합니다.
 * rank의 원소는 1부터 n까지의 정수로 모두 서로 다릅니다.
 * attendance[i]는 i번 학생의 전국 대회 참석 가능 여부를 나타냅니다.
 * attendance[i]가 true라면 참석 가능, false면 참석 불가능을 의미합니다.
 * attendance의 원소 중 적어도 3개는 true입니다.
 * 입출력 예
 * rank	attendance	result
 * [3, 7, 2, 5, 4, 6, 1]	[false, true, true, true, true, false, false]	20403
 * [1, 2, 3]	[true, true, true]	102
 * [6, 1, 5, 2, 3, 4]	[true, false, true, false, false, true]	50200
 */
public class 전국대회선발고사 {

    public static void main(String[] args) {
//        solution(new int[] {3, 7, 2, 5, 4, 6, 1}, new boolean[] {false, true, true, true, true, false, false});

        SolutionExOne s1 = new SolutionExOne();
        s1.solution(new int[] {3, 7, 2, 5, 4, 6, 1}, new boolean[] {false, true, true, true, true, false, false});
    }

    private static void solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        // rank 등수
        // attendance 참여여부
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) list.add(rank[i]);
        }
        // 오름차순
        Collections.sort(list);
        int mul = 10000;
        int checkInt = 0;
        for (int j = 0; j < list.size(); j++) {
            for (int k = 0; k < rank.length; k++) {
                if (list.get(j) == rank[k] && checkInt < 3) {
                    answer += (k * mul);
                    checkInt++;
                    mul = mul / 100;
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}


class SolutionExOne {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Student> arrayList = new ArrayList<>();
        for (int i = 0;i < attendance.length;i++) {
            if (attendance[i])
                arrayList.add(new Student(i, rank[i]));
        }
        Collections.sort(arrayList);
        Student a = arrayList.get(arrayList.size() - 1);
        Student b = arrayList.get(arrayList.size() - 2);
        Student c = arrayList.get(arrayList.size() - 3);
        return 10000 * a.order + 100 * b.order + c.order;
    }

    public class Student implements Comparable<Student> {
        int order;
        int number;

        public Student(int order, int number) {
            this.order = order;
            this.number = number;
        }

        @Override
        public int compareTo(Student o) {
            return o.number - this.number;
        }
    }
}