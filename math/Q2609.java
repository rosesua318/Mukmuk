package math;

import java.util.Scanner;

public class Q2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int g = GCD(a, b);
        System.out.println(g);
        System.out.println(a * b / g);
    }

    private static int GCD(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
