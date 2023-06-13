package graph;

import java.util.*;

public class Q4963 {
    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    public static final int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    public static void bfs(int[][] a, int[][] group, int x, int y, int count, int n, int m) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = count;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            x = p.x;
            y = p.y;
            for(int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = count;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if(n == 0 && m == 0) {
                break;
            }
            int[][] a = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            int[][] group = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(a[i][j] == 1 && group[i][j] == 0) {
                        bfs(a, group, i, j, ++count, n, m);
                    }
                }
            }
            System.out.println(count);
        }
    }
}