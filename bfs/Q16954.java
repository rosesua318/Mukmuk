package bfs;

import java.util.*;

public class Q16954 {
    final static int dx[] = { 0, 0, 1, -1, 1, -1, 1, -1, 0 }; // (0, 0) : 제자리에 머무는 경우 + 8방향
    final static int dy[] = { 1, -1, 0, 0, 1, 1, -1, -1, 0 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8; // 8x8
        String a[] = new String[n]; // 맵 표시
        boolean check[][][] = new boolean[8][8][9]; // 방문 여부 표시
        for(int i = 0; i < n; i++) {
            a[i] = sc.next(); // 지도 입력 받기
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(7); q.add(0); q.add(0); // 시작점이 왼쪽 아래이기 때문에 7행 0열 0초가 시작점이다.
        check[7][0][0] = true;

        boolean answer = false;
        while(!q.isEmpty()) {
            int x = q.poll(); // 행
            int y = q.poll(); // 열
            int t = q.poll(); // 현재 몇초
            if(x == 0 && y == 7) { // 도착점인 경우
                answer = true; // 가능함을 표시
            }
            for(int k = 0; k < 9; k++) { // 9방향에 대해서
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nt = Math.min(t + 1, 8); // 1초 지났으니까 증가 시키는데 8초 이상으론 안되게(8초 이후는 벽이 없으므로 8초로 고정)
                if(0 <= nx && nx < n && 0 <= ny && ny < n) { // 범위 안인 경우
                    if(nx - t >= 0 && a[nx - t].charAt(ny) == '#') { // t초 후에 이동할 칸이 벽인 경우 : a[nx - t, ny] 확인
                        continue; // 건너뛰기
                    }
                    if(nx - t - 1 >= 0 && a[nx - t - 1].charAt(ny) == '#') { // t+1초 후에 이동하고 났을 때 벽이 되어버리는 경우 : a[nx - t - 1, ny] 확인
                        continue; // 건너뛰기
                    }
                    if(check[nx][ny][nt] == false) { // 이동 가능하면서 아직 방문하지 않은 경우
                        check[nx][ny][nt] = true; // 방문 표시
                        q.add(nx); q.add(ny); q.add(nt);
                    }
                }
            }
        }
        System.out.println(answer ? 1 : 0); // 가능한지 아닌지 1또는 0 출력
    }
}