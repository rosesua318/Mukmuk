package dp;

import java.io.*;

public class Q9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long a[][] = new long[n + 1][2];
            String[] str = br.readLine().split(" ");
            for(int i = 1; i <= n; i++) {
                a[i][0] = Long.parseLong(str[i - 1]);
            }

            str = br.readLine().split(" ");
            for(int i = 1; i <= n; i++) {
                a[i][1] = Long.parseLong(str[i - 1]);
            }

            long d[][] = new long[n + 1][3];
            for(int i = 1; i <= n; i++) {
                d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[i][0];
                d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i][1];
            }

            long answer = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(answer);
        }
    }
}