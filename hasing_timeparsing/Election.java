package hasing_timeparsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Election {
    public static String solution(String[] votes, int k) {
        String answer = " ";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();
        for(String x : votes) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1); // 추천 받은 횟수 카운팅
        }

        int max = Integer.MIN_VALUE;
        for(String a : voteHash.keySet()) {
            int count = 0;
            for(String b : voteHash.get(a)) {
                if(candidate.get(b) >= k) { // k번 이상 추천 받은 경우
                    count++; // a가 받는 선물 개수 증가
                }
                present.put(a, count);
                max = Math.max(max, count); // 선물 받는 개수 중 최대값 찾기
            }
        }

        ArrayList<String> tmp = new ArrayList<>();
        for(String name : present.keySet()) {
            if(present.get(name) == max) {
                tmp.add(name);
            }
        }
        tmp.sort((a, b) -> a.compareTo(b)); // 사전순으로 정렬
        answer = tmp.get(0); // 가장 앞에 있는 이름
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Election.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
    }
}
