package bfs;

import java.util.*;

// 백준 1261번 알고스팟
public class Q1261 {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 열
        int n = sc.nextInt(); // 행
        sc.nextLine();
        int a[][] = new int[n][m]; // 맵
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int dx[] = { 0, 0, 1, -1 }; // 4방향
        int dy[] = { 1, -1, 0, 0 };
        int d[][] = new int[n][m]; // 벽을 부순 횟수 저장
        ArrayDeque<Pair> deque = new ArrayDeque<Pair>(); // 가중치가 0(벽 부수기x), 1(벽 부수기o)이기 때문에 덱을 이용해서 0은 덱의 앞에, 1은 덱의 뒤에 넣어주기
        deque.add(new Pair(0, 0)); // 시작점 넣어주기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                d[i][j] = -1; // 처음에는 가중치 -1로 초기화
            }
        }

        d[0][0] = 0; // 시작점은 벽을 부순 횟수가 0이므로 저장
        while(!deque.isEmpty()) {
            Pair p = deque.poll();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) { // 범위 안인 경우
                    if(d[nx][ny] == -1) { // 아직 방문하지 않은 경우
                        if(a[nx][ny] == 0) { // 빈방인 경우
                            d[nx][ny] = d[x][y]; // 벽 안 뚫기 때문에 가중치 증가 없이 저장
                            deque.addFirst(new Pair(nx, ny)); // 가중치가 0이므로 덱의 앞에 삽입
                        } else { // 벽인 경우
                            d[nx][ny] = d[x][y] + 1; // 벽을 뚫는 경우기 때문에 가중치를 +1 하기
                            deque.addLast(new Pair(nx, ny)); // 가중치가 1이므로 덱의 뒤에 삽입
                        }
                    }
                }
            }
        }
        System.out.println(d[n - 1][m - 1]); // 도착점의 벽을 부순 횟수 출력해주기
    }
}