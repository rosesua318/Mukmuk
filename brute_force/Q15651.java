package brute_force;

import java.util.*;

public class Q15651 {
    static boolean check[] = new boolean[10];
    static int a[] = new int[10];
    static StringBuilder go(int index, int n, int m) {
        if(index == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(a[i]);
                if(i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            check[i] = true;
            a[index] = i;
            sb.append(go(index + 1, n, m));
            check[i] = false;
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(go(0, n, m));
    }
}