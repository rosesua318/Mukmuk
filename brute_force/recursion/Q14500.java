package brute_force.recursion;

import java.util.*;

public class Q14500 {
    static int a[][];
    static boolean c[][];
    static int n, m;
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { 1, -1, 0, 0 };
    static int answer = 0;
    static void go(int x, int y, int sum, int count) {
        if(count == 4) { // 도형 1개 완성
            answer = Math.max(answer, sum); // 최댓값 구하기
            return;
        }
        // 불가능한 경우
        if(x < 0 || x >= n || y < 0 || y >= m) { // 범위 밖
            return;
        }
        if(c[x][y]) { // 이미 방문한 경우
            return;
        }

        c[x][y] = true; // 방문함
        for(int k = 0; k < 4; k++) {
            go(x + dx[k], y + dy[k], sum + a[x][y], count + 1); // 다음 칸
        }
        c[x][y] = false; // 초기화
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        c = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                go(i, j, 0, 0); // 재귀 함수 호출
                if(j + 2 < m) {
                    int temp = a[i][j] + a[i][j + 1] + a[i][j + 2];
                    if(i - 1 >= 0) { // ㅜ
                        int temp2 = temp + a[i - 1][j + 1];
                        answer = Math.max(answer, temp2);
                    }
                    if(i + 1 < n) { // ㅗ
                        int temp2 = temp + a[i + 1][j + 1];
                        answer = Math.max(answer, temp2);
                    }
                }
                if(i + 2 < n) {
                    int temp = a[i][j] + a[i + 1][j] + a[i + 2][j];
                    if(j + 1 < m) { // ㅏ
                        int temp2 = temp + a[i + 1][j + 1];
                        answer = Math.max(answer, temp2);
                    }
                    if(j - 1 >= 0) { // ㅓ
                        int temp2 = temp + a[i + 1][j - 1];
                        answer = Math.max(answer, temp2);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}