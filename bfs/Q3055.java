package bfs;

import java.util.*;

public class Q3055 {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int dx[] = { 1, -1, 0, 0 }; // 4방향
    public static int dy[] = { 0, 0, 1, -1 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열
        sc.nextLine();
        String a[] = new String[n]; // 지도
        int water[][] = new int[n][m]; // 물이 언제 차는지 시간 저장
        int d[][] = new int[n][m]; // 고슴도치가 언제 해당 칸에 도착하는지 시간 저장
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLine(); // 지도 입력 받기
            for(int j = 0; j < m; j++) {
                water[i][j] = -1; // 처음에는 -1로 초기화
                d[i][j] = -1; // 처음에는 -1로 초기화
            }
        }

        Queue<Pair> q = new LinkedList<>(); // (행,열) 정점
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i].charAt(j) == '*') { // 물인 경우
                    q.offer(new Pair(i, j)); // 물이 차는 시간 bfs로 계산하기 위해 큐에 삽입
                    water[i][j] = 0; // 시작점이므로 0초 저장
                } else if(a[i].charAt(j) == 'S') { // 고슴도치 위치인 경우
                    sx = i;
                    sy = j;
                } else if(a[i].charAt(j) == 'D') { // 비버 소굴 위치인 경우
                    ex = i;
                    ey = j;
                }
            }
        }

        // 해당 칸에 물이 언제 차는지 시간 계산하기 위한 bfs
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++) { // 4방향 탐색
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) { // 범위 밖인 경우
                    continue; // 건너뛰기
                }
                if(water[nx][ny] != -1) { // 시간이 이미 계산된 경우
                    continue; // 건너뛰기
                }
                if(a[nx].charAt(ny) == 'X') { // 돌인 경우(물이 갈 수 없음)
                    continue; // 건너뛰기
                }
                if(a[nx].charAt(ny) == 'D') { // 도착지인 비버 소굴인 경우(물이 갈 수 없음)
                    continue; // 건너뛰기
                }
                water[nx][ny] = water[x][y] + 1; // 시간 업데이트
                q.offer(new Pair(nx, ny));
            }
        }

        // 해당 칸에 고슴도치가 도착하는 시간 계산하기 위한 bfs 탐색
        q.offer(new Pair(sx, sy)); // 고슴도치 위치를 시작점으로 큐에 삽입
        d[sx][sy] = 0; // 시작점이므로 0 저장
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int k = 0; k < 4; k++) { // 4방향 탐색
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) { // 범위 밖인 경우
                    continue; // 건너뛰기
                }
                if(d[nx][ny] != -1) { // 이미 방문한 경우
                    continue; // 건너뛰기
                }
                if(a[nx].charAt(ny) == 'X') { // 돌인 경우(고슴도치가 갈 수 없음)
                    continue; // 건너뛰기
                }
                if(water[nx][ny] != -1 && d[x][y] + 1 >= water[nx][ny]) { // 해당 칸에 물이 올 수 있으면서 고슴도치가 도착하는 시간 보다 물의 도착 시간이 더 빨라서 이동했을 때 물인 경우(갈 수 없음)
                    continue; // 건너뛰기
                }
                d[nx][ny] = d[x][y] + 1; // 시간 업데이트
                q.offer(new Pair(nx, ny));
            }
        }

        if(d[ex][ey] == -1) { // 고슴도치가 비버 소굴에 도착하지 못한 경우
            System.out.println("KAKTUS"); // 못간다고 출력
        } else { // 도착할 수 있는 경우
            System.out.println(d[ex][ey]); // 가장 빠른 도착 시간 출력
        }
    }
}