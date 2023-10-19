package dp;

import java.util.*;

public class Q1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n + 1][3]; // 각 집을 빨강, 초록, 파랑으로 칠하는 비용
        int d[][] = new int[n + 1][3]; // d[i][j] : i번째 집을 j 색으로 칠했을 때 1~i번 집을 칠하는 비용의 최소값(j = 0: 빨강, 1: 초록, 2: 파랑)
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt(); // 비용 입력 받기
            }
        }

        for(int i = 1; i <= n; i++) { // 1부터 탐색
            // 1. i번째 집을 빨강색으로 칠하는 d[i][0]의 경우
            // i-1번째 집에는 초록이나 파랑을 칠해야 하므로 d[i-1][1]과 d[i-1][2] 중에서 최소값에다가 i번째집을 빨강색으로 칠하는 비용인 a[i][0]을 더해주기
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
            // 2. i번째 집을 초록색으로 칠하는 d[i][1]의 경우
            // i-1번째 집에는 빨강이나 파랑을 칠해야 하므로 d[i-1][0]과 d[i-1][2] 중에서 최소값에다가 i번째집을 초록색으로 칠하는 비용인 a[i][1]을 더해주기
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
            // 3. i번째 집을 파랑색으로 칠하는 d[i][2]의 경우
            // i-1번째 집에는 빨강이나 초록을 칠해야 하므로 d[i-1][0]과 d[i-1][1] 중에서 최소값에다가 i번째집을 파랑색으로 칠하는 비용인 a[i][2]을 더해주기
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
        }

        // 최종적으로 n번째 집까지 칠하는 비용의 최소값은 d[n][0]과 d[n][1], d[n][2] 중에서 최소값 출력
        System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
    }
}