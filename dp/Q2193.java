package dp;

import java.util.Scanner;

public class Q2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long d[][] = new long[n + 1][2];
        d[1][1] = 1;
        d[1][0] = 0;
        for(int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][1] + d[i - 1][0];
            d[i][1] = d[i - 1][0];
        }

        System.out.println(d[n][0] + d[n][1]);
    }
}
