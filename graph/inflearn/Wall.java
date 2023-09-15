package graph.inflearn;

import java.util.*;

public class Wall {
    public static int solution(int[][] board) {
        int dx[] = {-1, 0, 1, 0}; // 4방향 탐색 위해
        int dy[] = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int cost[][] = new int[n][m]; // 출발점부터 i행 j열까지 가는 데 부숴야 하는 최소 벽의 개수
        for(int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE); // 처음에 cost 배열을 최대값으로 채우기
        }
        cost[0][0] = 0; // 출발 지점은 벽 부순 개수 0개
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 다익스트라를 위해 벽의 개수가 적은 것부터 나오도록 우선순위 큐 사용
        pq.add(new int[]{0, 0, 0}); // 0행 0열 부순 개수 0개 넣기
        while(!pq.isEmpty()) { // 다익스트라
            int cur[] = pq.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) { // 우선순위 큐에서 나온 비용값이 기존 cost 배열에 있는 비용값 보다 큰 경우 -> 최소가 아니므로 더 탐색할 필요 x
                continue; // 건너뛰기
            }
            for(int k = 0; k < 4; k++) { // 4방향 탐색
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) { // 격자 밖인 경우
                    continue;
                }
                if(board[nx][ny] == 0 && cost[nx][ny] > cur[2]) { // 갈려고 하는 지점이 통로(부술 필요x)이면서 cost에 있는 비용 값보다 이동할 정점의 비용값이 더 작은 경우
                    cost[nx][ny] = cur[2]; // cost 비용값 갱신
                    pq.offer(new int[]{nx, ny, cur[2]}); // 우선순위 큐에 삽입
                } else if(board[nx][ny] == 1 && cost[nx][ny] > cur[2] + 1) { // 갈려고 하는 지점이 벽이면서 cost에 있는 비용 값 보다 이동할 정점의 비용값 + 1(벽이므로 부숴야함)이 더 작은 경우
                    cost[nx][ny] = cur[2] + 1; // cost 비용값 갱신
                    pq.offer(new int[]{nx, ny, cur[2] + 1}); // 우선순위 큐에 삽입
                }
            }
        }
        return cost[n - 1][m - 1]; // 도착지점의 비용값 반환
    }
    public static void main(String[] args) {
        System.out.println(Wall.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
    }
}
