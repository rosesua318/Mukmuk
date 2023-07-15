package binarysearch;

import java.util.*;

public class Q1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long left = 1;
        long right = n * n; // A[i][j]의 최대값은 n * n
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for(long i = 1; i <= n; i++) {
                count += Math.min(n, mid / i); // mid / i가 n을 넘어가는 경우엔 n으로
            }
            if(count >= k) { // k 이상인 경우
                answer = mid;
                right = mid - 1; // 더 작게
            } else {
                left = mid + 1; // 더 크게
            }
        }
        System.out.println(answer);
    }
}