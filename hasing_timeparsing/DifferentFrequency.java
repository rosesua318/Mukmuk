package hasing_timeparsing;

import java.util.HashMap;
import java.util.HashSet;

public class DifferentFrequency {
    public static int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> sh = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();
        for(char x : s.toCharArray()) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        for(char key : sh.keySet()) {
            while(ch.contains(sh.get(key))) {
                answer++;
                sh.put(key, sh.get(key) - 1);
            }
            if(sh.get(key) == 0) {
                continue;
            }
            ch.add(sh.get(key));
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(DifferentFrequency.solution("aebbbbc"));
    }
}
