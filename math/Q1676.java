package math;

import java.util.*;

public class Q1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        System.out.println(count);
    }
}