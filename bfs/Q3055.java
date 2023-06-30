package bfs;

import java.util.*;

public class Q3055 {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int dx[] = { 1, -1, 0, 0 };
    public static int dy[] = { 0, 0, 1, -1 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String a[] = new String[n];
        int water[][] = new int[n][m];
        int d[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
            for(int j = 0; j < m; j++) {
                water[i][j] = -1;
                d[i][j] = -1;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i].charAt(j) == '*') { // 물인 경우
                    q.offer(new Pair(i, j));
                    water[i][j] = 0; // 0초
                } else if(a[i].charAt(j) == 'S') { // 고슴도치 위치
                    sx = i;
                    sy = j;
                } else if(a[i].charAt(j) == 'D') { // 비버 소굴 위치
                    ex = i;
                    ey = j;
                }
            }
        }

        // 물 언제 차는지 계산
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) { // 범위 밖인 경우
                    continue;
                }
                if(water[nx][ny] != -1) { // 이미 계산된 경우
                    continue;
                }
                if(a[nx].charAt(ny) == 'X') { // 돌인 경우
                    continue;
                }
                if(a[nx].charAt(ny) == 'D') { // 도착지인 경우
                    continue;
                }
                water[nx][ny] = water[x][y] + 1; // 시간 업데이트
                q.offer(new Pair(nx, ny));
            }
        }

        // 고슴도치 도착 가능한지 탐색
        q.offer(new Pair(sx, sy)); // 고슴도치 위치를 시작점으로
        d[sx][sy] = 0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) { // 범위 밖인 경우
                    continue;
                }
                if(d[nx][ny] != -1) { // 이미 방문한 경우
                    continue;
                }
                if(a[nx].charAt(ny) == 'X') { // 돌인 경우
                    continue;
                }
                if(water[nx][ny] != -1 && d[x][y] + 1 >= water[nx][ny]) { // 이동했을 때 물인 경우
                    continue;
                }
                d[nx][ny] = d[x][y] + 1; // 시간 업데이트
                q.offer(new Pair(nx, ny));
            }
        }

        if(d[ex][ey] == -1) { // 도착하지 못한 경우
            System.out.println("KAKTUS");
        } else {
            System.out.println(d[ex][ey]);
        }
    }
}