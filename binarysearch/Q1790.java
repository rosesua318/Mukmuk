package binarysearch;

import java.util.*;

public class Q1790 {
    static long calc(int n) { // 수의 길이 구하기
        long answer = 0;
        for(int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1; // 그 자릿수 중 가장 마지막 값
            if(end > n) {
                end = n;
            }
            answer += (long) (end - start + 1) * len;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        if(calc(n) < k) { // n 까지의 길이가 k 보다 작은 경우(불가능함)
            System.out.println(-1);
            System.exit(0);
        }

        int left = 1;
        int right = n;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            long len = calc(mid);
            if(len < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        String s = Integer.toString(answer);
        long l = calc(answer);
        System.out.println(s.charAt(s.length() - 1 - (int)(l - k)));
    }
}