package brute_force.bitmask;

import java.util.*;

public class Q1182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // 수열 입력 받기
        }

        int answer = 0;
        for(int i = 1; i < (1 << n); i++) { // 공집합을 제외하고 1부터 전체 집합을 모두 탐색하여 모든 수열을 만들어 보기
            int sum = 0; // 수열의 합
            for(int k = 0; k < n; k++) { // 각각의 k번째 수가 포함되어 있는지 탐색
                if((i & (1 << k)) != 0) { // 집합 i에 k번째 수가 포함되어 있는 경우
                    sum += a[k]; // 수열의 합에 k번째 수의 값을 더해주기
                }
            }
            if(sum == s) { // 수열의 합이 s가 되는 경우
                answer += 1; // 경우의 수 1 더해주기
            }
        }

        System.out.println(answer);
    }
}