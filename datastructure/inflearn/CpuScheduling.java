package datastructure.inflearn;

import java.util.*;

public class CpuScheduling {
    public static int[] solution(int[][] tasks) {
        int n = tasks.length;
        int answer[] = new int[n];
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            programs.add(new int[]{ tasks[i][0], tasks[i][1], i}); // 작업 호출 시간, 실행 시간, 작업 번호로 이루어진 programs
        }
        programs.sort((a, b) -> a[0] - b[0]); // 호출 시간을 기준으로 오름차순 정렬

        // 우선 순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]; // 실행 시간이 작은 것을 우선, 같다면 작업 번호가 작은 것을 우선
        });

        int ft = 0;
        int index = 0;
        while(!programs.isEmpty() || !pq.isEmpty()) { // prorams 탐색이 끝나지 않았거나 우선순위 큐가 비어있지 않은 경우 계속 반복
            if(pq.isEmpty()) { // 우선 순위 큐가 비어있는 경우 -> ft를 다음 작업의 호출시간으로 건너뛰어야 함
                ft = Math.max(ft, programs.peek()[0]); // programs 작업 호출 시간과 ft 둘 중 큰 값으로 업데이트
            }
            while(!programs.isEmpty() && programs.peek()[0] <= ft) { // ft 보다 작은 호출 시간을 가진 작업들 모두 꺼내서 우선순위 큐에 삽입
                int x[] = programs.pollFirst();
                pq.add(new int[]{ x[1], x[2] });
            }
            int ex[] = pq.poll(); // 실행 시간이 가장 작은 작업 꺼내기
            ft = ft + ex[0]; // ft에 꺼낸 작업의 실행 시간 더해주기
            answer[index++] = ex[1]; // 꺼낸 작업의 번호 answer에 넣어주기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(CpuScheduling.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
    }
}
