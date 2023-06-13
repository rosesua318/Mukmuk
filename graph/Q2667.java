package graph;

import java.util.*;

public class Q2667 {
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
    public static void dfs(int[][] a, int[][] group, int x, int y, int count, int n) {
        group[x][y] = count; // 단지 번호
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(a[nx][ny] == 1 && group[nx][ny] == 0) { // 집이면서 방문하지 않은 경우
                    dfs(a, group, nx, ny, count, n); // 이웃하기 때문에 같은 단지임
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for(int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;
        int group[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 1 && group[i][j] == 0) {
                    dfs(a, group, i, j, ++count, n); // 새로운 단지 번호 부여
                }
            }
        }

        int answer[] = new int[count];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(group[i][j] != 0) {
                    answer[group[i][j] - 1] += 1; // 단지내 집의 개수 증가
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(count);
        for(int i = 0; i < count; i++) {
            System.out.println(answer[i]);
        }
    }
}