package math;

import java.util.*;

public class Q1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for(int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if(isPrime(t)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isPrime(int t) {
        if(t < 2) {
            return false;
        }
        for(int i = 2; i * i <= t; i++) {
            if(t % i == 0) {
                return false;
            }
        }
        return true;
    }
}