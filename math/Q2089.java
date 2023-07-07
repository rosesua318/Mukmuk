package math;

import java.util.*;

public class Q2089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        if(n == 0) {
            System.out.println(0);
        } else {
            while(n != 1) {
                sb.append(Math.abs(n % -2));
                n = (int) Math.ceil((double) n / -2);
            }
            sb.append(n);
        }
        System.out.println(sb.reverse());
    }
}
