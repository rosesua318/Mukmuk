package dp;

import java.util.*;

public class Q1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int d[] = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            d[i] = a[i];
        }

        int answer = d[0];
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                continue;
            }
            d[i] = Math.max(d[i - 1] + a[i], a[i]);
            answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }
}