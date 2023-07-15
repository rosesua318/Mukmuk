package binarysearch;

import java.util.*;

public class Q2343 {
    static int a[] = new int[100000];
    static int n, m;
    static boolean go(int size) {
        int count = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(sum + a[i] > size) { // 레슨의 합이 size를 넘을 때
                count += 1; // 새로운 블루레이 추가
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        return count <= m; // 블루레이 개수가 m개 이하인지
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int left = 0;
        int right = 0;
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            left = Math.max(left, a[i]); // 레슨 크기의 최대값 구하기
            right += a[i]; // 레슨 크기의 합 구하기
        }

        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(go(mid)) { // mid가 m개의 블루레이에 담을 수 있는 크기인 경우
                answer = mid;
                right = mid - 1; // 크기를 더 작게
            } else {
                left = mid + 1; // 크기를 더 크게
            }
        }
        System.out.println(answer);
    }
}