package graph;

import java.util.*;

public class Q2146 {
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int dx[] = { 0, 0, 1, -1 };
    public static final int dy[] = { 1, -1, 0, 0 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        int d[][] = new int[n][n];
        int g[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        // 각 섬들 그룹 번호 메기기
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 1 && g[i][j] == 0) {
                    Queue<Pair> q = new LinkedList<Pair>();
                    g[i][j] = ++count;
                    q.add(new Pair(i, j));
                    while(!q.isEmpty()) {
                        Pair p = q.poll();
                        int x = p.x;
                        int y = p.y;
                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if(a[nx][ny] == 1 && g[nx][ny] == 0) {
                                    q.add(new Pair(nx, ny));
                                    g[nx][ny] = count;
                                }
                            }
                        }
                    }
                }
            }
        }

        // 거리 계산 (섬을 확장하는 방식으로)
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                d[i][j] = -1;
                if(a[i][j] == 1) {
                    q.add(new Pair(i, j));
                    d[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if(d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        g[nx][ny] = g[x][y];
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        int answer = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(0 <= x && x < n && 0 <= y && y < n) {
                        if(g[i][j] != g[x][y]) { // 각 칸의 인접한 칸들 중 그룹 번호가 다른 경우 -> 다리 연결 가능
                            if(answer == -1 || answer > d[i][j] + d[x][y]) {
                                answer = d[i][j] + d[x][y]; // 각 거리들 중 최솟값 구하기
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}