package dfs.inflearn;

import java.util.*;

public class Palindrome {
    static Deque<Character> tmp;
    static ArrayList<String> res;
    static HashMap<Character, Integer> sh;
    static int len;
    public static void DFS() {
        if(tmp.size() == len) { // 팰린들롬 1개가 완성된 경우
            String ts = "";
            for(char x : tmp) {
                ts += x;
            }
            res.add(ts); // 정답에 문자열 추가
        } else {
            for(char key : sh.keySet()) { // 해시맵의 key에 대하여 탐색
                if(sh.get(key) == 0) { // 해당키의 빈도수가 0인 경우
                    continue; // 다음 경우로 넘어가기
                }
                tmp.addFirst(key); // 양끝에 key 문자 추가
                tmp.addLast(key);
                sh.put(key, sh.get(key) - 2); // 사용했으므로 빈도수 2 감소
                DFS(); // 다음 단계 가지 뻗도록
                tmp.pollFirst(); // 양끝 key 문자 회수
                tmp.pollLast();
                sh.put(key, sh.get(key) + 2); // 빈도수 2 증가시키기
            }
        }
    }
    public static String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        sh = new HashMap<>();
        len = s.length();
        for(char x : s.toCharArray()) { // s문자열에 사용된 문자들 빈도수 구하기
            sh.put(x, sh.getOrDefault(x, 0) + 1);
        }
        int odd = 0; // 홀수 문자의 개수
        char mid = '#'; // 홀수 개수인 문자가 있을 때 그 문자를 저장
        for(char key : sh.keySet()) {
            if(sh.get(key) % 2 == 1) { // 빈도수가 홀수개일 때
                mid = key; // 홀수 문자 저장
                odd++; // 홀수 문자의 개수 증가
            }
        }
        if(odd > 1) { // 홀수 개수인 문자가 1개보다 많을 때
            return new String[]{}; // 만들 수 없으므로 빈 배열 리턴
        }
        if(mid != '#') { // 홀수 개수인 문자가 1개만 존재하는 경우
            tmp.add(mid); // 해당 홀수 개수를 가진 문자 tmp에 추가해서 팰린드롬 문자열의 정중앙에 위치하게
            sh.put(mid, sh.get(mid) - 1); // 홀수 개수를 가진 문자 빈도수 1 감소
        }
        DFS(); // 재귀 함수 호출
        String answer[] = new String[res.size()]; // 정답 배열 생성
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Palindrome.solution("aaaabb")));
        System.out.println(Arrays.toString(Palindrome.solution("abbcc")));
        System.out.println(Arrays.toString(Palindrome.solution("abbccee")));
        System.out.println(Arrays.toString(Palindrome.solution("abbcceee")));
        System.out.println(Arrays.toString(Palindrome.solution("ffeffaae")));
    }
}
