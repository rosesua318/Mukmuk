package dp.inflearn;

import java.util.Scanner;

public class Stair {
    public static int solution(int n, int[] score) {
        int dy[] = new int[n + 1]; // i번 계단까지 올랐을 때 얻을 수 있는 최대 점수
        dy[1] = score[1]; // dy[0]은 0, dy[1]은 첫번째 계단이므로 경우의 수가 1개 뿐이라 score[1]
        if(n > 1) { // 테스트케이스에 계단 1개짜리 입력이 들어올 수 있기 때문에 오류 방지
            dy[2] = score[1] + score[2];
        }
        for(int i = 3; i <= n; i++) { // 세번째 계단부터 도착지점까지
            dy[i] = Math.max(dy[i - 2] + score[i], dy[i - 3] + score[i - 1] + score[i]); // 두칸 전에서 오는 경우와 세칸 전에서 두칸뛰어 전칸에 도착하고 전칸에서 오는 경우 중 최대점수로 지정
        }
        return dy[n]; // 도착지점 최대점수 리턴
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단의 개수
        int score[] = new int[n + 1]; // 계단에 쓰여진 점수
        for(int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }
        System.out.println(Stair.solution(n, score)); // 목적지의 최대점수 출력
    }
}
