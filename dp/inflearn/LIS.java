package dp.inflearn;

import java.util.*;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int d[] = new int[n];
        d[0] = 1;
        int answer = 0;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(a[j] < a[i] && d[j] > max) {
                    max = d[j];
                }
            }
            d[i] = max + 1;
            answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }
}
