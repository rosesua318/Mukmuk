package bfs.inflearn;

import java.util.*;

public class BuildHouse {
    public static int solution(int[][] board) {
        int answer = 0;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int n = board.length;
        int dist[][] = new int[n][n]; // dist[i][j] : 모든 빌딩에서 (i,j) 지점으로 가는 최단거리의 합
        Queue<int[]> q = new LinkedList<>();
        int emptyLand = 0; // 빈땅의 값을 나타낸다. 한 빌딩 탐색 끝날 때 마다 -1 감소 시켜주어 구분.
        for(int i = 0; i < n; i++) { // board 탐색
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) { // 빌딩을 만난 경우 -> 빌딩에서부터 bfs탐색해서 해당 빌딩에서 각 빈땅으로 가는 최단 거리를 dist 배열에 기록
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
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand) { // 범위 안이면서 해당 빌딩 기준 빈땅인 경우
                                    board[nx][ny]--; // 빈땅지점의 값을 1 감소 시킴 (다음 빌딩이 탐색할 때 구분하기 위함-공통되는 빈땅인지)
                                    dist[nx][ny] += L; // L(이동거리) 누적 해주기
                                    q.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, dist[nx][ny]); // 최단거리의 합 최소값으로 업데이트
                                }
                            }
                        }
                    }
                    emptyLand--; // 모든 빌딩들의 교집합인 빈땅을 구분하기 위한 변수이므로 한 빌딩 탐색할 때 마다 감소해서 업데이트 시켜줌
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer; // MAX인 경우 공통되는 빈땅이 없기 때문에 -1 리턴. 아니면 최소값 리턴
    }

    public static void main(String[] args) {
        System.out.println(BuildHouse.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0},
                {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(BuildHouse.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
    }
}
