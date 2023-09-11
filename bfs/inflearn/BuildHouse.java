package bfs.inflearn;

import java.util.*;

public class BuildHouse {
    public static int solution(int[][] board) {
        int answer = 0;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int n = board.length;
        int dist[][] = new int[n][n]; // 모든 빌딩에서 해당 지점으로 가는 데 최단거리로 가는 이동거리의 총합
        Queue<int[]> q = new LinkedList<>();
        int emptyLand = 0; // 빈땅의 값
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) { // 빌딩을 만난 경우 -> 빌딩에서부터 bfs탐색해서 각 빈땅으로 가는 최단 거리 구함
                    answer = Integer.MAX_VALUE; // 한 빌딩이라도 막혀있는 경우 -1을 리턴시키기 위해 매 빌딩마다 answer를 MAX로 초기화
                    q.offer(new int[]{i, j});
                    int L = 0;
                    while(!q.isEmpty()) {
                        L++;
                        int len = q.size();
                        for(int r = 0; r < len; r++) {
                            int cur[] = q.poll();
                            for(int k = 0; k < 4; k++) { // 자식 노드 탐색
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand) { // 범위 안이면서 빈땅인 경우
                                    board[nx][ny]--; // 빈땅지점의 값을 1 감소 시킴
                                    dist[nx][ny] += L; // L(이동거리) 누적 해주기
                                    q.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, dist[nx][ny]); // 최단거리 누적합 업데이트
                                }
                            }
                        }
                    }
                    emptyLand--; // 모든 빌딩들의 교집합인 빈땅여부 확인하기 위한 변수이므로 감소해서 업데이트 시켜줌
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(BuildHouse.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0},
                {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(BuildHouse.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
    }
}
