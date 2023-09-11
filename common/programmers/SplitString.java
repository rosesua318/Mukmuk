package common.programmers;

public class SplitString {
    static class Solution {
        public static int solution(String s) {
            int answer = 1; // 분해한 문자열의 개수
            int x = 0; // 첫 글자의 위치
            int y = 1; // 첫 글자와는 다른 글자의 위치
            int xcount = 1; // 첫 글자의 횟수
            int ycount = 0; // 다른 글자의 횟수

            while(y < s.length()) {
                if(xcount == ycount) { // 횟수가 같은 경우 (문자열 분해)
                    x = y; // 다른 글자의 위치를 첫 글자의 위치로 저장
                    y += 1; // 다른 글자 위치는 그 다음 +1한 위치
                    xcount = 1; // 횟수 초기화
                    ycount = 0;
                    answer++; // 분해한 횟수 증가
                } else {
                    if(s.charAt(x) == s.charAt(y)) { // 첫 글자와 같은 경우
                        xcount++;
                    } else { // 다른 경우
                        ycount++;
                    }
                    y++; // 다른 글자의 위치 증가
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(Solution.solution(s));
    }
}
