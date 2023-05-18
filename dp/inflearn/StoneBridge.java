package dp.inflearn;

import java.util.*;

public class StoneBridge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int d[] = new int[n + 2];
        d[1] = 1; d[2] = 2;
        for(int i = 3; i <= n + 1; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.print(d[n + 1]);
    }
}
