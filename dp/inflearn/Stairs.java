package dp.inflearn;

import java.util.*;

public class Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int d[] = new int[n + 1];
        d[1] = 1; d[2] = 2;
        for(int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.print(d[n]);
    }
}
