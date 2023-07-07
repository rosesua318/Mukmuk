package simulation.inflearn;

import java.util.Arrays;

public class Cleaning {
    static public int[] solution(int[][] board, int k) {
        int answer[] = new int[2];
        int n = board.length;
        int dx[] = { -1, 0, 1, 0 }; // 12시, 3시, 6시, 9시
        int dy[] = { 0, 1, 0, -1 };
        int x = 0, y = 0, d = 1, count = 0; // d: 방향 결정

        while(count < k) { // k초 전까지
            count++; // 1초 추가 (이동, 회전 모두 해당)
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) { // 범위 밖이거나 벽인 경우
                d = (d + 1) % 4; // 90도 회전
                continue; // 이동하지 않고 회전만
            }
            // 이동하기
            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}};
        int k = 10;
        System.out.println(Arrays.toString(Cleaning.solution(arr, k)));
    }
}
