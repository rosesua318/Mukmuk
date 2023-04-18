package math;

import java.util.*;

public class Q1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean check[] = new boolean[n + 1];
        check[0] = true;
        check[1] = true;
        for(int i = 2; i * i <= n; i++) {
            if(check[i]) {
                continue;
            }
            for(int j = i * 2; j <= n; j += i) {
                check[j] = true;
            }
        }

        for(int i = m; i <= n; i++) {
            if(!check[i]) {
                System.out.println(i);
            }
        }
    }
}
