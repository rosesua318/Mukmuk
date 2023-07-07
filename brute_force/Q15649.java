package brute_force;

import java.util.*;

public class Q15649 {
    static boolean check[] = new boolean[10];
    static int a[] = new int[10];
    static StringBuilder sb = new StringBuilder();
    static void go(int index, int n, int m) {
        if(index == m) {
            for(int i = 0; i < m; i++) {
                sb.append(a[i]);
                if(i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        for(int i = 1; i <= n; i++) {
            if(check[i]) {
                continue;
            }
            check[i] = true;
            a[index] = i;
            go(index + 1, n, m);
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        go(0, n, m);
        System.out.println(sb);
    }
}