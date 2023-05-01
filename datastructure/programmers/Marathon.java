package datastructure.programmers;

import java.util.*;

public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for(String c : completion) {
            if(map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
            if(map.get(c) == 0) {
                map.remove(c);
            }
        }

        for(String key : map.keySet()) {
            answer = key;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };
        Marathon m = new Marathon();
        System.out.println(m.solution(participant, completion));
    }
}