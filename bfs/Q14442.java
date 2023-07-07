package bfs;

import java.util.*;

public class Q14442 {
    static class Pair {
        int x, y, z;
        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static int dx[] = {1, -1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        sc.nextLine();
        int a[][] = new int[n][m];
        int d[][][] = new int[n][m][l + 1];
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new LinkedList<Pair>();
        d[0][0][0] = 1; // 시작점
        q.offer(new Pair(0, 0, 0));
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = p.z;
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) { // 범위 벗어나는 경우
                    continue;
                }
                if(a[nx][ny] == 0 && d[nx][ny][z] == 0) { // 빈칸이면서 방문하지 않은 경우
                    d[nx][ny][z] = d[x][y][z] + 1; // 거리 업데이트
                    q.offer(new Pair(nx, ny, z));
                }
                if(z + 1 <= l && a[nx][ny] == 1 && d[nx][ny][z + 1] == 0) { // 벽이면서 방문하지 않은 경우
                    d[nx][ny][z + 1] = d[x][y][z] + 1; // 거리 업데이트
                    q.offer(new Pair(nx, ny, z + 1));
                }
            }
        }

        int answer = -1;
        for(int i = 0; i <= l; i++) {
            if(d[n - 1][m - 1][i] == 0) { // 도달하지 못한 경우
                continue;
            }
            if(answer == -1) {
                answer = d[n - 1][m - 1][i];
            } else {
                answer = Math.min(answer, d[n - 1][m - 1][i]);
            }
        }
        System.out.println(answer);
    }
}