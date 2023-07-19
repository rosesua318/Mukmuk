package hasing_timeparsing;

import java.util.HashMap;

public class FirstChar {
    public static int solution(String s) {
        HashMap<Character, Integer> sh = new HashMap<>();
        for(char x : s.toCharArray()) {
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(sh.get(s.charAt(i)) == 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstChar.solution("statitsics"));
        System.out.println(FirstChar.solution("aabb"));
    }
}
