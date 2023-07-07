package dp;

import java.util.*;

public class Q13398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int d[] = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = a[i];
            if(i > 0) {
                d[i] = Math.max(d[i], d[i - 1] + a[i]);
            }
        }

        int d2[] = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            d2[i] = a[i];
            if(i < n - 1) {
                d2[i] = Math.max(d2[i], d2[i + 1] + a[i]);
            }
        }

        int answer = d[0];
        for(int i = 0; i < n; i++) { // 수를 제거하지 않는 경우
            answer = Math.max(answer, d[i]);
        }
        for(int i = 1; i < n - 1; i++) {
            answer = Math.max(answer, d[i - 1] + d2[i + 1]);
        }
        System.out.println(answer);
    }
}