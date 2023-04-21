package math;

import java.util.*;

public class Q11576 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            answer = answer * a + x;
        }
        convert(answer, b);
    }
    public static void convert(int num, int base) {
        if(num == 0) {
            return;
        }
        convert(num / base, base);
        System.out.print(num % base + " ");
    }
}