package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
 * 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가
 * 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
 *
 * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,
 * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
 *

 * 입출력 예
 * players	                                callings	                    result
 * ["mumu", "soe", "poe", "kai", "mine"]	["kai", "kai", "mine", "mine"]	["mumu", "kai", "mine", "soe", "poe"]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 4등인 "kai" 선수가 2번 추월하여 2등이 되고 앞서 3등, 2등인 "poe", "soe" 선수는 4등, 3등이 됩니다.
 * 5등인 "mine" 선수가 2번 추월하여 4등,
 * 3등인 "poe", "soe" 선수가 5등, 4등이 되고 경주가 끝납니다.
 * 1등부터 배열에 담으면 ["mumu", "kai", "mine", "soe", "poe"]이 됩니다.
 */
public class 달리기경주 {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println("solution = " + solution(players, callings)); ;
    }

    private static String[] solution(String[] players, String[] callings) {
        // indexOf
        // callings 의 이름을 먼저 찾고

        // 선수명, 등수
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String player : callings) {
            // 등수 호출
            int oneRank = map.get(player);
            // 앞서가던 선수 호출
            String beforePlayer = players[oneRank - 1];

            players[oneRank - 1] = player;
            players[oneRank] = beforePlayer;

            map.put(player, oneRank - 1);
            map.put(beforePlayer, oneRank);

        }

        for (String a : players) {
            System.out.println("players = " + a);
        }

        return players;
    }


}
