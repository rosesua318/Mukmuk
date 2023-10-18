package dp;

import java.util.*;

public class Q11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int d[] = new int[n]; // d[i]는 a[1]~a[i]까지 수열이 이루어져서 a[i]를 마지막 수로 하는 가장 긴 증가하는 부분 수열의 길이
        for(int i = 0; i < n; i++) { // 전체 탐색
            d[i] = 1;
            for(int j = 0; j < i; j++) { // j는 i보다 작은 수(i 앞에 올 수)
                if(a[j] < a[i]) { // j번째 수가 i번째 수 보다 작다면(수열 성립)
                    d[i] = Math.max(d[i], d[j] + 1); // j(i보다 작은 수)를 마지막 수로 하는 가장 긴 증가하는 부분 수열의 길이인 d[j]에서 +1
                }
            }
        }

        int answer = d[0];
        for(int i = 0; i < n; i++) {
            if(answer < d[i]) {
                answer = d[i]; // 최대 길이 찾기
            }
        }
        System.out.println(answer);
    }
}