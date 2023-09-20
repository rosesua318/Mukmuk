package graph.inflearn;

import java.util.*;

public class BallRolling {
    public static int solution(int[][] board, int[] s, int[] e) {
        int n = board.length;
        int m = board[0].length;
        int cost[][] = new int[n][m]; // i행 j열까지 가는데 공이 굴러가는 최소 이동 거리
        for(int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE); // 큰값으로 초기화 하기
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 이동 거리가 작은 순서대로 나오도록
        pq.add(new int[]{s[0], s[1], 0}); // 공의 시작 위치를 넣어주기
        cost[s[0]][s[1]] = 0; // 공의 시작 위치의 cost는 0
        while(!pq.isEmpty()) { // 다익스트라
            int cur[] = pq.poll(); // 우선순위 큐에서 하나 뽑기
            if(cur[2] > cost[cur[0]][cur[1]]) { // 이미 구해놓은 cost 배열 값이 현재 큐에서 꺼낸 거리값 보다 작은 경우 더 볼 필요 없음
                continue; // 건너 뛰기
            }
            for(int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 4방향에 대해서
                int nx = cur[0]; // 공의 행
                int ny = cur[1]; // 공의 열
                int len = cur[2]; // 출발지점에서 현재 지점까지 온 공의 이동 거리
                while(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) { // 벽 만나기 전까지 쭉 굴러가는 것 구현
                    nx += dir[0]; // 해당 방향으로 1씩 이동
                    ny += dir[1];
                    len++; // 굴러가므로 이동거리 1 증가
                }

                // 벽을 만나 멈춘 x,y 지점은 벽이 있는 지점임 -> 공이 굴러간 방향의 반대방향으로 한 칸 뒤로 이동 필요
                nx -= dir[0];
                ny -= dir[1];
                len--;

                if(cost[nx][ny] > len) { // cost 배열 값 보다 이동한 거리 len이 작은 경우
                    cost[nx][ny] = len; // 갱신해주기
                    pq.add(new int[]{nx, ny, len}); // 우선순위 큐에 넣어주기
                }
            }
        }
        if(cost[e[0]][e[1]] == Integer.MAX_VALUE) { // 초기값 그대로인 경우는 공이 도착 못한다는 뜻임
            return -1; // -1 리턴
        } else { // 공이 목적지에 도착한 경우
            return cost[e[0]][e[1]]; // 목적지의 cost 배열값 리턴
        }
    }
    public static void main(String[] args) {
        System.out.println(BallRolling.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(BallRolling.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
    }
}
