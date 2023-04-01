package programmers.level3.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 *
 * 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.
 */
public class 배스트앨범 {

    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});
    }

    public static int[] solution(String[] genres, int[] plays) {
        /**
         * Chat GPT
         */
        // 장르별 재생 횟수를 저장하기 위한 HashMap
        HashMap<String, Integer> totalPlay = new HashMap<>();
        // 장르별 노래 정보를 저장하기 위한 HashMap
        HashMap<String, ArrayList<Song>> songMap = new HashMap<>();

        // HashMap에 데이터 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // totalPlay HashMap에 장르별 재생 횟수 누적
            totalPlay.put(genre, totalPlay.getOrDefault(genre, 0) + play);

            // songMap HashMap에 노래 정보 저장
            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new ArrayList<>());
            }
            songMap.get(genre).add(new Song(i, play));
        }

        // totalPlay HashMap을 Value를 기준으로 내림차순 정렬
        List<String> keySetList = new ArrayList<>(totalPlay.keySet());
        Collections.sort(keySetList, (o1, o2) -> (totalPlay.get(o2).compareTo(totalPlay.get(o1))));

        // 재생 횟수가 많은 장르부터 노래 정보를 추출해서 베스트 앨범에 추가
        ArrayList<Integer> answerList = new ArrayList<>();
        for (String key : keySetList) {
            ArrayList<Song> songList = songMap.get(key);
            Collections.sort(songList);

            int count = 0;
            for (Song song : songList) {
                answerList.add(song.id);
                count++;
                if (count == 2) {
                    break;
                }
            }
        }

        // ArrayList를 int[] 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        for (int a : answer) System.out.println("answer = " + a);
        return answer;
    }
}
// 노래 정보를 저장하는 Song 클래스
class Song implements Comparable<Song> {
    int id; // 노래 고유 번호
    int play; // 노래 재생 횟수

    public Song(int id, int play) {
        this.id = id;
        this.play = play;
    }

    // Comparable 구현 메서드 - 재생 횟수를 기준으로 오름차순 정렬
    @Override
    public int compareTo(Song other) {
        if (this.play == other.play) {
            return this.id - other.id;
        } else {
            return other.play - this.play;
        }
    }
}