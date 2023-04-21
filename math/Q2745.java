package math;

import java.util.*;

public class Q2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();

        int answer = 0;
        for(int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if('0' <= c && c <= '9') {
                answer = answer * b + (c - '0');
            } else {
                answer = answer * b + (c - 'A' + 10);
            }
        }

        System.out.println(answer);
    }
}
