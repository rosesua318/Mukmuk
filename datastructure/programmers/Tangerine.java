package datastructure.programmers;

import java.util.*;

public class Tangerine {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine); // 크기 기준 오름차순 정렬

        HashMap<Integer, Integer> map = new HashMap<>(); // 크기 별로 개수 저장
        for(int i = 0; i < tangerine.length; i++) { // 귤 탐색
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1); // 크기 별 개수 구하기
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1))); // 개수가 많은 순으로 귤 크기 정렬

        for(int i : keySet) { // 귤 크기 탐색
            k -= map.get(i); // 개수가 많은 귤 크기 부터 상자에 담기 (담았으므로 k에서 빼줌)
            answer++; // 담은 귤의 종류 1 증가
            if(k <= 0) { // 담으려는 귤 다 담은 경우
                return answer; // 귤의 종류 리턴
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Tangerine.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 3
        System.out.println(Tangerine.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 2
        System.out.println(Tangerine.solution(	2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})); // 1
    }
}
