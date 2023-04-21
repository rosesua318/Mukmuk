package math;

import java.util.*;

public class Q11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int r = n % b;
            if(r < 10) {
                sb.append((char) (r + '0'));
            } else {
                sb.append((char) (r - 10 + 'A'));
            }
            n /= b;
        }

        System.out.println(sb.reverse());
    }
}
