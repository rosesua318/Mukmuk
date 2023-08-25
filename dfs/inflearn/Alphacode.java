package dfs.inflearn;

public class Alphacode {
    static int[] dy; // 메모이제이션을 위해
    public static int DFS(int start, String s) {
        if(dy[start] > 0) { // 이미 한번 구했던 경우
            return dy[start]; // 메모이제이션 이용
        }
        if(start < s.length() && s.charAt(start) == '0') { // 문자열의 끝이 아니면서 0으로 시작하는 문자열인 경우
            return 0; // 불가능하므로 0 리턴
        }
        if(start == s.length() - 1 || start == s.length()) { // 문자열 끝까지 도달한 경우(가지의 마지막)
            return 1; // 경우의 수 1 리턴
        } else {
            int res = DFS(start + 1, s); // 1자리 숫자 다음 가지 뻗어서 결과 반환 받기
            int tmp = Integer.parseInt(s.substring(start, start + 2)); // 두자리 숫자 만들기
            if(tmp <= 26) { // 알파벳 범위 안인 경우
                res += DFS(start + 2, s); // 2자리 숫자 다음 가지 뻗어서 결과 반환 받기
            }
            return dy[start] = res; // 메모이제이션 할당
        }
    }
    public static int solution(String s) {
        dy = new int[101];
        int answer = DFS(0, s);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Alphacode.solution("25114"));
        System.out.println(Alphacode.solution("23251232"));
    }
}
