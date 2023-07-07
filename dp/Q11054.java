package dp;

import java.util.*;

public class Q11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int d[] = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = 1;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i]) {
                    d[i] = Math.max(d[i] , d[j] + 1);
                }
            }
        }

        int d2[] = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            d2[i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(a[i] > a[j]) {
                    d2[i] = Math.max(d2[i], d2[j] + 1);
                }
            }
        }

        int answer = d[0] + d2[0] - 1;
        for(int i = 0; i < n; i++) {
            answer = Math.max(answer, d[i] + d2[i] - 1);
        }
        System.out.println(answer);
    }
}