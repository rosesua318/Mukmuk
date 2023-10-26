package common.programmers;

import java.util.*;

public class Cache {
    public static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase(); // 대소문자 구분하지 않기 위해
            if(cache.contains(s)) { // 캐시 히트일 때
                cache.remove(s); // 캐시에서 삭제시키기
                cache.add(s); // 마지막에 추가하기
                answer += 1; // 실행 시간 1 더하기
            } else { // 캐시 미스일 때
                if(cache.size() == cacheSize) { // 캐시가 꽉 찼을 때
                    cache.remove(0); // 0번 인덱스에 있는 데이터 삭제
                    cache.add(s); // 마지막에 추가하기
                } else { // 캐시 공간이 남아있을 때
                    cache.add(s); // 마지막에 추가하기
                }
                answer += 5; // 실행 시간 5 더하기
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Cache.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 50
        System.out.println(Cache.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 25
    }
}
