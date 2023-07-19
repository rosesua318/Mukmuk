package binarysearch;

import java.util.*;

public class Q13397 {
    public static int go(int[] a, int mid) {
        int n = a.length;
        int t1 = a[0];
        int t2 = a[0];
        int answer = 1;
        for(int i = 1; i < n; i++) {
            t1 = Math.min(t1, a[i]); // 구간의 최소값 구하기
            t2 = Math.max(t2, a[i]); // 구간의 최대값 구하기
            if(t2 - t1 > mid) {
                answer += 1; // 구간 추가
                t1 = a[i]; // 구간 최소값 초기화
                t2 = a[i]; // 구간 최대값 초기화
            }
        }
        return answer; // 구간 개수 리턴
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        int left = 0;
        int right = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            right = Math.max(right, a[i]); // 수의 최대값 구하기
        }

        int answer = right;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(go(a, mid) <= k) { // 구간 개수가 k 이하인 경우
                right = mid - 1; // 더 작게
                answer = Math.min(answer, mid); // 점수의 최소값 구하기
            } else {
                left = mid + 1; // 더 크게
            }
        }
        System.out.println(answer);
    }
}