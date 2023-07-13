package binarysearch;

import java.util.*;

public class Q2805 {
    public static boolean check(long[] a, long mid, long m) {
        long sum = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] - mid > 0) {
                sum += a[i] - mid;
            }
        }
        return sum >= m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long a[] = new long[n];
        long left = 0;
        long right = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            right = Math.max(right, a[i]); // 나무들 중 최대 높이를 right로
        }

        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(check(a, mid, m)) { // 길이 m을 만들 수 있는 경우
                answer = Math.max(answer, mid); // 절단기의 최대 높이 구하기
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}