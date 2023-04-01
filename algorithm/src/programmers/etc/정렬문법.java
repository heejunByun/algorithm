package programmers.etc;

import java.util.*;

public class 정렬문법 {
    public static void main(String[] args) {


        //1. 배열 정렬하기
        arraySort(new int[]{2, 4, 6, 1, 7, 8, 10, 15});
        //2. List 정렬하기
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 90, 10, 224, 52, 61);
        listSort(numbers);
        //3. Map Value 값 정렬하기
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 5);
        map.put("B", 1);
        map.put("C", 9);
        map.put("D", 3);
        map.put("E", 7);
        mapSort(map);
        //4. 문자열 정렬하기

    }

    public static void arraySort(int[] arr) {
        Arrays.sort(arr);
        System.out.println("arr = " + arr);
        for (int a : arr) System.out.println("1-1. 배열 오름차순 정렬 = " + a);

        // 배열 내림차순은 그냥 뒤에서부터 for 문 돌려서 생성할 것
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("1-2. 배열 내림차순 정렬 = " + arr[i]);
        }
        /**
         *  참고
         *  // int 형 배열은 내림차순 하기 힘듬
         *  Integer[] IntegerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
         *  Arrays.sort(IntegerArr, Collections.reverseOrder());
         *  for (int a : arr) System.out.println("1-2. 배열 내림차순 정렬 = " + a);
         */

    }

    public static void listSort(List<Integer> list) {
        System.out.println();

        Collections.sort(list);
        System.out.println("2-1. 리스트 오름차순 정렬 = " + list);

//        list.sort(Comparator.reverseOrder());
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("2-2. 리스트 내림차순 정렬 = " + list);
    }

    public static void mapSort(Map<String, Integer> map) {
        System.out.println();

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        System.out.println("3-1. 맵 Value 기준 오름차순 정렬 ");
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }


        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
               return o2.getValue() - o1.getValue();
           }
        });
        System.out.println("3-2. 맵 Value 기준 내림차순 정렬 ");
        for(Map.Entry<String, Integer> entry : entryList){
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }

        System.out.println("3-3. 맵 Key 기준 오름차순 정렬 ");
        Map<String, Integer> treeMap = new TreeMap<>(map);
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Map<String, Integer> treeMap2 = new TreeMap<>(Comparator.reverseOrder());
        treeMap2.putAll(map);
        System.out.println("3-4. 맵 Key 기준 내림차순 정렬 ");
        for (Map.Entry<String, Integer> entry : treeMap2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
