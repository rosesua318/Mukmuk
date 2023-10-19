package dp;

import java.io.*;

public class Q9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        while(t-- > 0) { // 테스트 케이스 반복
            int n = Integer.parseInt(br.readLine()); // 열 입력 받기
            long a[][] = new long[n + 1][2]; // 각 스티커의 점수
            String[] str = br.readLine().split(" ");
            for(int i = 1; i <= n; i++) {
                a[i][0] = Long.parseLong(str[i - 1]); // 위쪽 스티커들 점수 입력 받기
            }

            str = br.readLine().split(" ");
            for(int i = 1; i <= n; i++) {
                a[i][1] = Long.parseLong(str[i - 1]); // 아래쪽 스티커들 점수 입력 받기
            }

            // d[i][j]: i번 열에서 j 스티커를 뜯었을 때, 2 x i에서 얻을 수 있는 최대 점수(j = 0: 뜯지 않음, 1: 위쪽 스티커를 뜯음, 2: 아래쪽 스티커를 뜯음)
            long d[][] = new long[n + 1][3];
            for(int i = 1; i <= n; i++) { // 1번 열부터 탐색
                // 1. i번 열에서 스티커를 뜯지 않는 d[i][0]의 경우
                // i-1번 열에서 스티커를 어떻게 뜯든 상관 없으므로 뜯지 않거나 위쪽 스티커를 뜯거나 아래쪽 스티커를 뜯었을 때의 값 중 더 큰값(i번열에서는 뜯지 않으므로 점수 더하지 않아도 됨)
                d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
                // 2. i번 열에서 위쪽 스티커를 뜯는 d[i][1]의 경우
                // i-1번 열에서 위쪽 스티커를 뜯으면 안되므로 뜯지 않거나 아래쪽 스티커를 뜯었을 때의 값 중 더 큰 값에 i번 열 위쪽 스티커의 점수를 더해주기
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[i][0];
                // 3. i번 열에서 아래쪽 스티커를 뜯는 d[i][2]의 경우
                // i-1번 열에서 아래쪽 스티커를 뜯으면 안되므로 뜯지 않거나 위쪽 스티커를 뜯었을 때의 값 중 더 큰 값에 i번 열 아래쪽 스티커의 점수를 더해주기
                d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i][1];
            }

            // 2 x n에서 얻을 수 있는 최대 점수는 d[n][0], d[n][1], d[n][2] 중에서 최대값
            long answer = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(answer);
        }
    }
}