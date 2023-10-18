package common.programmers;

public class Bracket {
    public static int solution(int n, int a, int b) {
        int answer = 0;
        while(true) {
            a = (a / 2) + (a % 2); // 짝수면 나누기 2, 홀수면 나누기 2 + 1
            b = (b / 2) + (b % 2);
            answer++; // 게임 수 증가
            if(a == b) {
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Bracket.solution(8, 4, 7));
    }
}
