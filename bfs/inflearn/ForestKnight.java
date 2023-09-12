package bfs.inflearn;

import java.util.*;

public class ForestKnight {
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int dist[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 2 || board[i][j] == 3) { // 영희나 기사가 발견된 경우 (단 2번만 참이됨)
                    q.offer(new int[]{i, j});
                    int check[][] = new int[n][m]; // bfs 탐색 할 때 마다(영희, 기사 촏 2번) 새로 초기화
                    check[i][j] = 1;
                    int L = 0;
                    while(!q.isEmpty()) {
                        L++; // 이동 거리 증가
                        int len = q.size();
                        for(int r = 0; r < len; r++) {
                            int cur[] = q.poll();
                            for(int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) { // 범위 안이면서 접근 가능한 위치인 경우(1이 아닌 경우)
                                    if(check[nx][ny] == 0) {
                                        check[nx][ny] = 1;
                                        dist[nx][ny] += L; // 이동거리 누적해주기 (dist[nx][ny] : 영희위치에서 nx,ny로 간 거리와 기사위치에서 nx,ny로 간 거리의 합)
                                        q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 4 && dist[i][j] > 0) { // 산딸기의 위치이면서 영희가 접근 가능한 산딸기인 경우(거리가 0보다 크면 구했단 뜻이므로)
                    answer = Math.min(answer, dist[i][j]); // 최단거리 구해주기
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(ForestKnight.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0}, {0, 0, 0, 4, 1, 1, 1, 0}}));
    }
}
