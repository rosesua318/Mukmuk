package bfs;

import java.util.*;

public class Q16954 {
    final static int dx[] = { 0, 0, 1, -1, 1, -1, 1, -1, 0 }; // (0, 0) 안 움직이는 경우
    final static int dy[] = { 1, -1, 0, 0, 1, 1, -1, -1, 0 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        String a[] = new String[n];
        boolean check[][][] = new boolean[8][8][9];
        for(int i = 0; i < n; i++) {
            a[i] = sc.next();
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(7); q.add(0); q.add(0); // 시작점
        check[7][0][0] = true;

        boolean answer = false;
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int t = q.poll();
            if(x == 0 && y == 7) { // 도착점인 경우
                answer = true;
            }
            for(int k = 0; k < 9; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nt = Math.min(t + 1, 8); // 8초 이상으론 안되게(8초 이후는 벽이 없음)
                if(0 <= nx && nx < n && 0 <= ny && ny < n) { // 범위 안인 경우
                    if(nx - t >= 0 && a[nx - t].charAt(ny) == '#') { // 이동하기 전에 봤을 때 다음 칸이 벽인 경우
                        continue;
                    }
                    if(nx - t - 1 >= 0 && a[nx - t - 1].charAt(ny) == '#') { // 이동하고 나면 벽이 내려오는 경우
                        continue;
                    }
                    if(check[nx][ny][nt] == false) { // 아직 방문하지 않은 경우
                        check[nx][ny][nt] = true;
                        q.add(nx); q.add(ny); q.add(nt);
                    }
                }
            }
        }
        System.out.println(answer ? 1 : 0);
    }
}