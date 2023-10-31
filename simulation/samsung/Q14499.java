package simulation.samsung;

import java.io.*;
import java.util.*;

public class Q14499 {
    //      top
    // left now right
    //     bottom
    //     nowtop
    static class Dice {
        int now, left, right, top, bottom, nowtop;
        public Dice(int now, int left, int right, int top, int bottom, int nowtop) {
            this.now = now;
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
            this.nowtop = nowtop;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dx[] = {0, 0, 0, -1, 1}; // 1번째 : 동, 2번째 : 서, 3번째 : 북, 4번째 : 남
        int dy[] = {0, 1, -1, 0, 0};
        Dice dice = new Dice(0, 0, 0, 0, 0, 0); // 모두 0으로 초기화
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int order = Integer.parseInt(st.nextToken());

            // 주문대로 굴리기
            x = x + dx[order];
            y = y + dy[order];
            if(x < 0 || x >= n || y < 0 || y >= m) { // 범위 밖인 경우
                x -= dx[order]; // 해당 명령 무시
                y -= dy[order];
                continue;
            }

            if(order == 1) { // 동쪽으로 주사위 굴리기
                int temp = dice.left;
                dice.left = dice.now;
                dice.now = dice.right;
                dice.right = dice.nowtop;
                dice.nowtop = temp;
            } else if(order == 2) { // 서쪽으로 주사위 굴리기
                int temp = dice.left;
                dice.left = dice.nowtop;
                dice.nowtop = dice.right;
                dice.right = dice.now;
                dice.now = temp;
            } else if(order == 3) { // 북쪽으로 주사위 굴리기
                int temp = dice.now;
                dice.now = dice.top;
                dice.top = dice.nowtop;
                dice.nowtop = dice.bottom;
                dice.bottom = temp;
            } else if(order == 4) { // 남쪽으로 주사위 굴리기
                int temp = dice.now;
                dice.now = dice.bottom;
                dice.bottom = dice.nowtop;
                dice.nowtop = dice.top;
                dice.top = temp;
            }

            if(map[x][y] == 0) { // 이동하는 칸의 값이 0이면 주사위 바닥면의 값 복사
                map[x][y] = dice.now;
            } else { // 이동하는 칸의 값이 0이 아닌 경우 그 값을 주사위 바닥면의 값에 복사하고 이동하는 칸의 값은 0으로 변경
                dice.now = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice.nowtop).append("\n"); // 주사위 윗면 출력
        }
        System.out.println(sb);
    }
}
