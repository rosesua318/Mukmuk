package bfs;

import java.util.*;

// 백준 14226번 이모티콘
public class Q14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[][] = new int[n + 1][n + 1]; // -1: 방문하지 않음, 0이상 : 방문함
        for(int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        d[1][0] = 0; // 화면에 이모티콘 1개, 클립보드에 이모티콘 0개로 시작
        while(!q.isEmpty()) {
            int s = q.poll(); // 화면의 이모티콘 개수
            int c = q.poll(); // 클립보드의 이모티콘 개수
            if(d[s][s] == -1) { // 아직 복사 안한 경우
                d[s][s] = d[s][c] + 1; // 시간 1 증가
                q.add(s); q.add(s);
            }
            if(s + c <= n && d[s + c][c] == -1) { // 아직 붙여넣기 안한 경우
                d[s + c][c] = d[s][c] + 1; // 시간 1 증가
                q.add(s + c); q.add(c);
            }
            if(s - 1 >= 0 && d[s - 1][c] == -1) { // 아직 삭제 안한 경우
                d[s - 1][c] = d[s][c] + 1; // 시간 1 증가
                q.add(s - 1); q.add(c);
            }
        }

        int answer = -1;
        for(int i = 0; i <= n; i++) {
            if(d[n][i] != -1) { // 구해야 하는 화면의 이모티콘 개수가 n이면서 클립 보드의 이모티콘 개수가 i인데 계산을 했던 경우
                if(answer == -1 || answer > d[n][i]) {
                    answer = d[n][i]; // 걸리는 시간을 최소값으로 업데이트 해주기
                }
            }
        }
        System.out.println(answer);
    }
}