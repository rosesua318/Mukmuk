package bfs.inflearn;

import java.util.*;

public class Maze {
    public static int solution(int[][] board) {
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        int dist[][] = new int[7][7];
        q.offer(new int[]{0, 0});
        int L = 0;
        while(!q.isEmpty()) {
            L++; // nx, ny의 레벨로 적용하기 위해 먼저 1증가시켜주기 -> 이동횟수로 사용할 수 있게
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int p[] = q.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = p[0] + dx[k];
                    int ny = p[1] + dy[k];
                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0) { // 범위 안이면서 벽이 아니고 방문하지 않은 경우
                        board[nx][ny] = 1; // 방문 표시
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L; // 레벨(이동횟수)를 dist배열에 저장
                    }
                }
            }
        }
        if(dist[6][6] == 0) {
            return -1;
        } else {
            return dist[6][6];
        }
    }
    public static void main(String[] args) {
        System.out.println(Maze.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}}));
        System.out.println(Maze.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}}));
    }
}
