package dp;

import java.util.*;

public class Q16194 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n + 1]; // 카드팩의 가격
        for (int i=  1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int[] d = new int[n + 1]; // d[i] : 카드 i개를 구매할 때 드는 비용의 최소값
        for(int i = 1; i <= n; i++) { // 1부터 n까지 탐색
            d[i] = -1; // 최소값을 구해야 하기 때문에 d배열의 초기값을 0이 아닌 -1로 지정해주기
            for(int j = 1; j <= i; j++) {
                if(d[i] == -1 || d[i] > d[i - j] + p[j]) { // 초기값인 -1이거나 d[i]가 d[i - j] + p[j] 보다 큰 경우
                    d[i] = d[i - j] + p[j]; // 업데이트 시켜주기
                }
            }
        }
        System.out.println(d[n]); // 카드 n개를 구매할 때 드는 비용의 최소값 출력
    }
}