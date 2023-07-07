package dp;

import java.util.*;

public class Q1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int d[][] = new int[n][n];
        d[0][0] = a[0][0];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                d[i][j] = d[i - 1][j] + a[i][j];
                if(j - 1 >= 0 && d[i][j] < d[i - 1][j - 1] + a[i][j]) {
                    d[i][j] = d[i - 1][j - 1] + a[i][j];
                }
            }
        }

        int answer = d[n - 1][0];
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, d[n - 1][i]);
        }
        System.out.println(answer);
    }
}