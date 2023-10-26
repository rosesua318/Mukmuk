package bfs.samsung;

import java.io.*;
import java.util.*;

public class Q13460 {
    static int n, m;
    static int map[][];
    static boolean[][][][] checked;
    static int min = Integer.MAX_VALUE; // 최소 이동 횟수
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static void bfs(int rx, int ry, int bx, int by, int count) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rx, ry, bx, by, count});
        checked[rx][ry][bx][by] = true;
        while(!q.isEmpty()) {
            int p[] = q.poll();
            int pCount = p[4];
            if(pCount >= 10) { // 움직인 횟수가 10회 이상인 경우
                return; // 더 탐색하지 않고 종료
            }
            for(int i = 0; i < 4; i++) { // 4방향
                int nrx = p[0]; // 빨간구슬의 x좌표
                int nry = p[1]; // 빨간구슬의 y좌표
                int nbx = p[2]; // 파란구슬의 x좌표
                int nby = p[3]; // 파란구슬의 y좌표

                // 빨간 구슬 이동
                while(map[nrx + dx[i]][nry + dy[i]] != 0) { // 이동하려는 곳이 벽이 아닐 때 까지 반복
                    nrx += dx[i]; // 해당 방향으로 계속 이동
                    nry += dy[i];
                    if(map[nrx][nry] == 44) { // 빨간 구슬이 구멍에 들어간 경우
                        break; // 멈추기
                    }
                }

                // 파란 구슬 이동
                while(map[nbx + dx[i]][nby + dy[i]] != 0) { // 이동하려는 곳이 벽이 아닐 때 까지 반복
                    nbx += dx[i]; // 해당 방향으로 계속 이동
                    nby += dy[i];
                    if(map[nbx][nby] == 44) { // 파란 구슬이 구멍에 들어간 경우
                        break; // 멈추기
                    }
                }

                if(map[nbx][nby] == 44) { // 파란 구슬이 구멍에 들어갔을 때
                    continue; // 다음 탐색으로 넘어가기
                }
                if(map[nrx][nry] == 44) { // 빨간 구슬이 구멍에 들어갔을 때
                    min = Math.min(min, pCount + 1); // 최소 이동 횟수 업데이트 해주기
                }

                // 빨간 구슬과 파란 구슬이 서로 만나면서 빨간 구슬이 구멍에 들어가지 않았을 때
                if(nrx == nbx && nry == nby && map[nrx][nry] != 44) {
                    int rmove = Math.abs(nrx - p[0]) + Math.abs(nry - p[1]); // 빨간 구슬이 이동한 거리 구하기
                    int bmove = Math.abs(nbx - p[2]) + Math.abs(nby - p[3]); // 파란 구슬이 이동한 거리 구하기

                    // 파란 구슬이 더 빨리 도착한 경우(이동 거리가 더 짧으면 빨리 도착)
                    if(rmove > bmove) {
                        nrx -= dx[i]; // 빨간 구슬 한칸 전으로 보내기
                        nry -= dy[i];
                    } else { // 빨간 구슬이 더 빨리 도착한 겨우(이동 거리가 더 짧으면 빨리 도착)
                        nbx -= dx[i]; // 파란 구슬 한칸 전으로 보내기
                        nby -= dy[i];
                    }
                }

                if(!checked[nrx][nry][nbx][nby]) { // 아직 탐색하지 않은 경우
                    checked[nrx][nry][nbx][nby] = true; // 방문 표시
                    q.add(new int[]{nrx, nry, nbx, nby, pCount + 1});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        checked = new boolean[n][m][n][m];

        int rx = 0, ry = 0;
        int bx = 0, by = 0;
        for(int i = 0 ; i < n; i++) {
            String line[] = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                // R : 47, B : 31, 0 : 44, # : 0, . : 11
                int num = line[j].charAt(0) - '0' + 13;
                map[i][j] = num;
                if(num == 47) { // 빨간 구슬인 경우
                    rx = i; ry = j;
                } else if(num == 31) { // 파란 구슬인 경우
                    bx = i; by = j;
                }
            }
        }

        bfs(rx, ry, bx, by, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
