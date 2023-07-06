package greedy;

import java.util.*;

public class Q11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int answer = 0;
        for(int i = n - 1; i >= 0; i--) { // 큰 순서대로
            answer += k / a[i];
            k %= a[i];
        }
        System.out.println(answer);
    }
}