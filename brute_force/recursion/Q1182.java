package brute_force.recursion;

import java.util.*;

public class Q1182 {
    public static int go(int a[], int m, int i, int sum) {
        if(i == a.length) {
            if(sum == m) { // 정답을 찾은 경우
                return 1;
            } else {
                return 0;
            }
        }
        return go(a, m, i + 1, sum + a[i]) + go(a, m, i + 1, sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int answer = go(a, m, 0, 0);
        if(m == 0) {
            answer -= 1;
        }
        System.out.println(answer);
    }
}
