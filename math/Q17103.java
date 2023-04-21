package math;

import java.util.*;

public class Q17103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        boolean check[] = new boolean[1000001];
        check[0] = check[1] = true;

        for(int i = 0; i * i <= 1000000; i++) {
            if(check[i]) {
                continue;
            }
            for(int j = i * 2; j <= 1000000; j += i) {
                check[j] = true;
            }
        }

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int count = 0;
            for(int j = 2; j <= n / 2; j++) {
                if(!check[j] && !check[n - j]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
