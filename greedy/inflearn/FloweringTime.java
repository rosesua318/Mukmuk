package greedy.inflearn;

import java.util.Arrays;

public class FloweringTime {
    public static int solution(int[] plantTime, int[] growTime) {
        int answer = 0;
        int n = plantTime.length;
        int list[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }
        Arrays.sort(list, (a, b) -> b[1] - a[1]); // 성장기간 기준 내림차순 정렬(성장기간이 긴걸 먼저 심는 게 최단시간을 구할 수 있음)
        int start = 0, end = 0;
        for(int[] x : list) {
            end = start + x[0] + x[1]; // x 꽃까지 피는 데 걸리는 시간
            answer = Math.max(answer, end); // 모든 꽃이 피는 데 걸리는 최단 시간을 구하기 위해 업데이트
            start += x[0]; // 다음번째가 시작되는 시점을 위해 x꽃 심는데 걸리는 시간 더해주기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(FloweringTime.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
    }
}
