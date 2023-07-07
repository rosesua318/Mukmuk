package bfs;

import java.util.*;

public class Q6087 {
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static final int dx[] = { 0, 0, 1, -1 };
    static final int dy[] = { 1, -1, 0, 0 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String a[] = new String[n];
        int sx, sy, ex, ey;
        sx = sy = ex = ey = -1;
        for(int i = 0; i < n; i++) {
            a[i] = sc.next();
            for(int j = 0; j < m; j++) {
                if(a[i].charAt(j) == 'C') {
                    if(sx == -1) {
                        sx = i;
                        sy = j;
                    } else {
                        ex = i;
                        ey = j;
                    }
                }
            }
        }

        int d[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sx, sy)); // 시작점
        d[sx][sy] = 0;

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.first;
            int y = p.second;
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                while(0 <= nx && nx < n && 0 <= ny && ny < m) { // 범위 내에서 반복
                    if(a[nx].charAt(ny) == '*') { // 벽인 경우
                        break;
                    }
                    if(d[nx][ny] == -1) { // 아직 방문하지 않은 경우
                        d[nx][ny] = d[x][y] + 1;
                        q.add(new Pair(nx, ny));
                    }
                    // 네방향에 있는 모든 점 탐방
                    nx += dx[k];
                    ny += dy[k];
                }
            }
        }

        System.out.println(d[ex][ey] - 1);
    }
}