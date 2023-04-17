package math;

import java.util.Scanner;

public class Q1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a * b / GCD(a, b));
        }
    }

    public static int GCD(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
