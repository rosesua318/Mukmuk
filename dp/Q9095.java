package dp;

import java.util.*;

public class Q9095 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[11]; // d[i] : i를 1,2,3의 합으로 나타내는 방법의 수
        d[0] = 1; // 0은 1로 초기화 해주기

        for(int i = 1; i <= 10; i++) { // 1부터 10까지 반복
            for(int j = 1; j <= 3; j++) { // i-1, i-2, i-3
                if(i - j >= 0) {
                    d[i] += d[i - j]; // d[i] = d[i - 1] + d[i - 2] + d[i - 3] 해준 것.
                }
            }
        }

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}