package dp;

import java.util.*;

public class Q16194 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n + 1];
        for (int i=  1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int[] d = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            d[i] = -1;
            for(int j = 1; j <= i; j++) {
                if(d[i] == -1 || d[i] > d[i - j] + p[j]) {
                    d[i] = d[i - j] + p[j];
                }
            }
        }
        System.out.println(d[n]);
    }
}