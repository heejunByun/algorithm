package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다.
 * 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.
 * <p>
 * 예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 경화가 귤 6개를 판매하고 싶다면,
 * 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
 * <p>
 * 경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다.
 * 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * 1 ≤ k ≤ tangerine의 길이 ≤ 100,000
 * 1 ≤ tangerine의 원소 ≤ 10,000,000
 * 입출력 예
 * k	tangerine	result
 * 6	[1, 3, 2, 5, 4, 5, 2, 3]	3
 * 4	[1, 3, 2, 5, 4, 5, 2, 3]	2
 * 2	[1, 1, 1, 1, 2, 2, 2, 3]	1
 */
public class 귤고르기 {

    public static void main(String[] args) {
        solution(6, new int [] {1,3,2,5,4,5,2,3});
        solution(4, new int [] {1,3,2,5,4,5,2,3});
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        // 재귀함수??
        // 각 크기만큼 카운트 필요
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : tangerine) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.println("map = " + map);

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                int a0 = map.get(o1);
                int a1 = map.get(o2);
                if (a0 == a1) return 0;
                else if (a0 < a1) return 1; //내림차순
                // 오름차순 else if (a0 > a1) return 1;
                else return -1;
            }
        });
        //위와 아래가 동일한 코드라고 함
        // keyList.sort((a1, a2) -> map.get(a2) - map.get(a1)); //내림차순
        // keyList.sort((a1, a2) -> map.get(a1) - map.get(a2)); //오름차순
        for (Integer a : keyList) {
            System.out.println("aaaa = " + a);
        }

        int i = 0;
        while (k > 0) {
            System.out.println("k = " + k);
            System.out.println("map.get(keyList.get(i)); = " + map.get(keyList.get(i)));
            k -= map.get(keyList.get(i));
            answer++;
            i++;
        }


        System.out.println("answer = " + answer);
        return answer;
    }
}

