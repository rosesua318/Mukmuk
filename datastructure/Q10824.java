package datastructure;

import java.util.*;

public class Q10824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long d = sc.nextInt();

        long answer1 = Long.valueOf(a + String.valueOf(b));
        long answer2 = Long.valueOf(c + String.valueOf(d));
        System.out.println(answer1 + answer2);
    }
}