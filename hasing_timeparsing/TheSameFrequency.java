package hasing_timeparsing;

import java.util.Arrays;
import java.util.HashMap;

public class TheSameFrequency {
    public static int[] solution(String s) {
        int answer[] = new int[5];
        HashMap<Character, Integer> sh = new HashMap<>();
        for(char x : s.toCharArray()) {
            sh.put(x, sh.getOrDefault(x, 0) + 1); // 문자열의 빈도수 구하기
        }

        int max = Integer.MIN_VALUE;
        String tmp = "abcde";
        for(char key : tmp.toCharArray()) {
            if(sh.getOrDefault(key, 0) > max) {
                max = sh.getOrDefault(key, 0); // 빈도수 최대값 구하기
            }
        }
        for(int i = 0; i < tmp.length(); i++) {
            answer[i] = max - sh.getOrDefault(tmp.charAt(i), 0); // 각 문자의 필요 추가 개수 구하기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(TheSameFrequency.solution("aaabc")));
        System.out.println(Arrays.toString(TheSameFrequency.solution("aabb")));
    }
}
