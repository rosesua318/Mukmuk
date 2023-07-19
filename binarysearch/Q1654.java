package binarysearch;

import java.util.*;

public class Q1654 {
    public static boolean check(long[] a, int m, long x) {
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            count += a[i] / x;
        }
        return count >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long a[] = new long[n];
        long max = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }

        long left = 1;
        long right = max; // 입력 받은 랜선 길이 중 최댓값
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(check(a, m, mid)) { // mid로 m개의 랜선을 만들 수 있는 경우
                answer = Math.max(answer, mid); // 최대 길이 구하기
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}