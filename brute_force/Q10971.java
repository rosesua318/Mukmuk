package brute_force;

import java.util.*;

public class Q10971 {
    public static boolean next_permutation(int a[]) {
        int i = a.length - 1;
        while(i > 0 && a[i - 1] >= a[i]) { // 1단계
            i -= 1;
        }

        if(i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while(a[j] <= a[i - 1]) { // 2단계
            j -= 1;
        }

        int temp = a[i - 1]; // 3단계
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while(i < j) { // 4단계
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int d[] = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = i;
        }

        int answer = Integer.MAX_VALUE;
        do {
            if(d[0] != 0) {
                break;
            }
            boolean ok = true;
            int sum = 0;
            for(int i = 0; i < n - 1; i++) {
                if(a[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += a[d[i]][d[i + 1]];
                }
            }
            if(ok && a[d[n - 1]][d[0]] != 0) {
                sum += a[d[n - 1]][d[0]];
                answer = Math.min(answer, sum);
            }
        } while(next_permutation(d));

        System.out.println(answer);
    }
}