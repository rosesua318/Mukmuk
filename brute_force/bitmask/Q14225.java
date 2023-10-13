package brute_force.bitmask;

import java.util.*;
public class Q14225 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean c[] = new boolean[20 * 100000 + 10]; // c[i] = true : 수 i를 만들 수 있음
        int a[] = new int[20]; // 입력 받은 수들 저장
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < (1 << n); i++) { // 전체 집합을 모두 탐색하여 모든 수열을 만들기
            int sum = 0;
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) { // 집합 i에 j번째 수가 포함되어 있는 경우
                    sum += a[j]; // 수열의 합에 j번째 수의 값을 더해주기
                }
            }
            c[sum] = true; // 수열의 합 sum을 만들 수 있음을 c배열에 표시
        }
        for(int i = 1; ; i++) { // 1부터 무한반복하면서
            if(c[i] == false) { // 수 i를 만들 수 없는 경우
                System.out.println(i); // 해당 i를 출력해주고
                break; // 끝내기
            }
        }
    }
}