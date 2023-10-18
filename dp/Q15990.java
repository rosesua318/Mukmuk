package dp;

import java.util.*;

public class Q15990 {
    static final long mod = 1000000009L;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long d[][] = new long[100001][4]; // d[i][j] : 마지막엔 j를 사용해서 i를 1,2,3의 합으로 나타내는 방법의 수
        for(int i = 1; i <= 100000; i++) { // 1부터 10만까지 탐색
            if(i - 1 >= 0) {
                // 마지막에 1를 사용하는 경우의 수 = 마지막에 2를 사용해서 i-1를 나타내는 경우의 수 + 마지막에 3을 사용해서 i-1를 나타내는 경우의 수
                d[i][1] = d[i - 1][2] + d[i - 1][3];
                if(i == 1) {
                    d[i][1] = 1; // 제일 처음엔 초기화해주기
                }
            }
            if(i - 2 >= 0) {
                // 마지막에 2를 사용하는 경우의 수 = 마지막에 1를 사용해서 i-2를 나타내는 경우의 수 + 마지막에 3을 사용해서 i-2를 나타내는 경우의 수
                d[i][2] = d[i - 2][1] + d[i - 2][3];
                if(i == 2) {
                    d[i][2] = 1; // 제일 처음엔 초기화해주기
                }
            }
            if(i - 3 >= 0) {
                // 마지막에 3를 사용하는 경우의 수 = 마지막에 1를 사용해서 i-3를 나타내는 경우의 수 + 마지막에 2을 사용해서 i-3를 나타내는 경우의 수
                d[i][3] = d[i - 3][1] + d[i - 3][2];
                if(i == 3) {
                    d[i][3] = 1; // 제일 처음엔 초기화해주기
                }
            }
            d[i][1] %= mod;
            d[i][2] %= mod;
            d[i][3] %= mod;
        }

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println((d[n][1] + d[n][2] + d[n][3]) % mod); // d[n]는 모든 경우의 수이므로 d[n][1] + d[n][2] + d[n][3]의 합이 된다.
        }
    }
}