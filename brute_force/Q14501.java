package brute_force;

import java.util.*;

public class Q14501 {
    static int t[];
    static int p[];
    static int n;
    static int answer = 0;
    static void go(int day, int sum) {
        if(day == n + 1) {
            answer = Math.max(answer, sum);
            return;
        }
        if(day > n + 1) {
            return;
        }
        go(day + 1, sum);
        go(day + t[day], sum + p[day]);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        go(1, 0);
        System.out.println(answer);
    }
}