package brute_force;

import java.util.*;

public class Q1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int a = 1, b = 1, c = 1;
        for(int i = 1; ; i++) {
            if(a == e && b == s && c == m) {
                System.out.println(i);
                break;
            }
            a += 1;
            b += 1;
            c += 1;
            if(a == 16) {
                a = 1;
            }
            if(b == 29) {
                b = 1;
            }
            if(c == 20) {
                c = 1;
            }
        }
    }
}