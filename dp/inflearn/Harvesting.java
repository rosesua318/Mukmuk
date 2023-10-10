package dp.inflearn;

import java.util.Scanner;

public class Harvesting {
    public static int solution(int n, int[] nums) {
        int dy[][] = new int[n + 1][n + 1]; // dy[i][j] : i번째 벼부터 j번째벼까지를 수확했을 때 얻을 수 있는 최대 이익
        int sum[] = new int[n + 1]; // 누적합 구하는 배열
        sum[1] = nums[1];
        for(int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i]; // 누적합 구해주기
        }
        for(int i = 1; i <= n; i++) {
            dy[i][i] = nums[i]; // 길이가 1인 수열들은 값이 자기 자신의 가치임.
        }
        for(int i = 1; i < n; i++) { // i가 1일때는 길이가 2인 수열 탐색. i가 2일때는 길이가 3인 수열 탐색. ,,,. i가 n-1일때는 길이가 n인 수열 탐색
            for(int j = 1; j <= n - i; j++) { // (j, j+i)는 i가 1일때는 (1,2),(2,3),(3,4),(4,5). i가 2일때는 (1,3),(2,4),(3,5) 이런식으로 돎
                // 첫번째 벼를 먼저 수확했을 때의 다이나믹 값(dy[i+1][j]) 마지막 벼를 먼저 수확했을 때의 다이나믹 값(dy[i][j-1]) 중 최대값에 i번째부터 j번째까지의 요소들의 누적합 더한 값을 다이나믹값으로 지정해주면 됨
                dy[j][j + i] = Math.max(dy[j + 1][j + i], dy[j][j + i - 1]) + (sum[j + i] - sum[j - 1]);
            }
        }
        return dy[1][n]; // 전체 벼를 수확했을 때의 최대 이익 리턴
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Harvesting.solution(n, nums));
    }
}

