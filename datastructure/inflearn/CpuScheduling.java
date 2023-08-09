package datastructure.inflearn;

import java.util.*;

public class CpuScheduling {
    public static int[] solution(int[][] tasks) {
        int n = tasks.length;
        int answer[] = new int[n];
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            programs.add(new int[]{ tasks[i][0], tasks[i][1], i});
        }
        programs.sort((a, b) -> a[0] - b[0]); // 실행 시간을 기준으로 오름차순 정렬

        // 우선 순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        int ft = 0, index = 0;
        while(!programs.isEmpty() || !pq.isEmpty()) {
            if(pq.isEmpty()) {
                ft = Math.max(ft, programs.peek()[0]);
            }
            while(!programs.isEmpty() && programs.peek()[0] <= ft) {
                int x[] = programs.pollFirst();
                pq.add(new int[]{ x[1], x[2] });
            }
            int ex[] = pq.poll();
            ft = ft + ex[0];
            answer[index++] = ex[1];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(CpuScheduling.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
    }
}
