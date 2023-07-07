package brute_force;

import java.util.*;

public class Q1107 {
    static boolean broken[] = new boolean[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            broken[x] = true;
        }

        int answer = Math.abs(n - 100);

        for(int i = 0; i <= 1000000; i++) {
            int c = i;
            int len = possible(c);
            if(len > 0) {
                int press = Math.abs(c - n);
                answer = Math.min(answer, len + press);
            }
        }
        System.out.println(answer);
    }

    static int possible(int c) {
        if(c == 0) {
            if(broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while(c > 0) {
            if(broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }
}