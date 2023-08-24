package dfs.inflearn;

import java.util.*;

public class IPAddress {
    static LinkedList<String> tmp;
    static ArrayList<String> res;
    public static void DFS(int start, String s) {
        if(tmp.size() == 4 && start == s.length()) { // IP주소 4자리가 다 만들어졌고, 시작인덱스도 문자열의 끝을 가리킬 때
            String ts = "";
            for(String x : tmp) {
                ts += x + ".";
            }
            res.add(ts.substring(0, ts.length() - 1)); // 결과 배열에 IP주소 추가(마지막 .은 뺀채로 넣도록)
        } else {
            for(int i = start; i < s.length(); i++) {
                if(s.charAt(start) == '0' && i > start) { // 0으로 시작하면서 두자리 숫자 이상인 경우
                    return; // 재귀를 더 진행하지 않도록 리턴
                }
                String num = s.substring(start, i + 1);
                if(Integer.parseInt(num) > 255) { // 자른 숫자가 255보다 큰 경우
                    return; // 더이상 for문 진행못하도록 리턴
                }
                tmp.add(num); // IP주소 만들수 있도록 집어넣기
                DFS(i + 1, s); // 다음 가지 뻗기
                tmp.pollLast(); // tmp에 있던 num 회수하기
            }
        }
    }
    public static String[] solution(String s) {
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);
        String answer[] = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(IPAddress.solution("2025505")));
        System.out.println(Arrays.toString(IPAddress.solution("255003")));
        System.out.println(Arrays.toString(IPAddress.solution("155032012")));
    }
}
