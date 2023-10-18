package dp;

import java.util.*;

public class Q2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long d[][] = new long[k + 1][n + 1]; // d[i][j]는 0부터 i까지의 정수 중에 i개를 더해서 그 합이 j가 되는 경우의 수
        d[0][0] = 1;
        for(int i = 1; i <= k; i++) { // k개
            for(int j = 0; j <= n; j++) { // 합이 n
                for(int l = 0; l <= j; l++) { // l의 범위는 0부터 n까지
                    // 마지막에 더하는 수를 l이라고 하면 그의 앞의 경우인 0부터 i-1까지의 정수 중에 i-1개를 더해서 그 합이 j-l이 되는 경우의 수인 d[i-1][j-l] 모두 더해주기
                    d[i][j] += d[i - 1][j - l];
                    d[i][j] %= 1000000000L;
                }
            }
        }
        System.out.println(d[k][n]);
    }
}