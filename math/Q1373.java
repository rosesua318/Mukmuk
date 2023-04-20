package math;

import java.util.*;

public class Q1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        if(n % 3 == 1) { // 세자리씩 끊었는데 한 자리만 남았을 경우
            System.out.print(s.charAt(0));
        } else if(n % 3 == 2) { // 세자리씩 끊었는데 두 자리만 남았을 경우
            System.out.print((s.charAt(0) - '0') * 2 + (s.charAt(1) - '0'));
        }

        for(int i = n % 3; i < n; i += 3) {
            System.out.print((s.charAt(i) - '0') * 4 + (s.charAt(i + 1) - '0') * 2 + (s.charAt(i + 2) - '0'));
        }

        System.out.println();
    }
}