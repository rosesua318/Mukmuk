package brute_force;

import java.util.*;

public class Q1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long answer = 0;
        for(int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1; // 해당 자리수 중에서 가장 큰 값
            if(end > n) {
                end = n;
            }
            answer += (long) (end - start + 1) * len;
        }
        System.out.println(answer);
    }
}