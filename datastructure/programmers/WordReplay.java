package datastructure.programmers;

import java.util.*;

public class WordReplay {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> map = new HashMap<>(); // 단어 중복 체크

        for(int i = 0; i < words.length; i++) { // 단어 탐색
            if(i != 0) { // 첫시작이 아닌 경우
                String w1 = words[i - 1]; // 이전 단어
                String w2 = words[i]; // 현재 단어

                char last = w1.charAt(w1.length() - 1); // 이전 단어의 마지막 철자
                char first = w2.charAt(0); // 현재 단어의 처음 철자

                if(map.containsKey(w2) || last != first) { // 단어가 중복이거나 끝말잇기가 안 되는 경우
                    answer[0] = (i % n) + 1; // 번호
                    answer[1] = (i / n) + 1; // 차례

                    return answer;
                }
            }

            map.put(words[i], 1); // 사용한 단어 맵에 저장
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(WordReplay.solution(3, new String[]{"tank", "kick", "know", "wheel", "land",
        "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(WordReplay.solution(5, new String[]{"hello", "observe", "effect", "take", "either",
        "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
    }
}
