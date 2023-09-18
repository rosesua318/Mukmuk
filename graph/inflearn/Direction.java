package graph.inflearn;

import java.util.*;

public class Direction {
    public static int solution(int[][] board) {
        int dx[] = {0, 0, 1, -1}; // 1, 2, 3, 4 순서대로
        int dy[] = {1, -1, 0, 0};
        int n = board.length;
        int m = board[0].length;
        int cost[][] = new int[n][m]; // 0행 0열에서부터 i행 j열까지의 격자 바뀐 최소 횟수
        for(int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE); // 다익스트라이므로 최대값으로 초기화
        }
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 격자 바꾼 횟수가 작은 순서대로 나옴
        pq.add(new int[]{0, 0, 0}); // (행, 열, 격자 바꾼 횟수)
        while(!pq.isEmpty()) { // 다익스트라
            int cur[] = pq.poll(); // 우선순위 큐에서 꺼냄
            int dir = board[cur[0]][cur[1]] - 1; // 보드에 적힌 방향값에서 1빼야 인덱스로 접근 가능
            if(cur[2] > cost[cur[0]][cur[1]]) { // cost에 있는 값이 더 작으면 탐색할 필요 없음
                continue; // 건너뛰기
            }
            for(int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) { // 격자밖인 경우
                    continue;
                }
                if(k == dir && cost[nx][ny] > cur[2]) { // 보드판에 적힌 방향과 일치해서 격자 바꿀 필요 없는 경우
                    cost[nx][ny] = cur[2]; // 횟수 증가 없이 업데이트
                    pq.offer(new int[]{nx, ny, cur[2]});
                } else { // 보드판에 적힌 방향과 달라서 바뀐 횟수 1 증가시켜야 하는 경우
                    if(cost[nx][ny] > cur[2] + 1) {
                        cost[nx][ny] = cur[2] + 1; // 횟수 1 증가한 값으로 업데이트
                        pq.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        return cost[n - 1][m - 1]; // 도착지의 격자 바꾼 횟수 리턴
    }
    public static void main(String[] args) {
        System.out.println(Direction.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(Direction.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
    }
}
