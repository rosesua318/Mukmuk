package brute_force.recursion;

import java.util.*;

public class Q1987 {
    public static final int dx[] = {0, 0, 1, -1};
    public static final int dy[] = {1, -1, 0, 0};
    public static int go(String board[], boolean check[], int x, int y) {
        int answer = 0;
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length()) {
                if(check[board[nx].charAt(ny) - 'A'] == false) { // 다음 칸의 알파벳을 방문한 적이 없을 때
                    check[board[nx].charAt(ny) - 'A'] = true; // 방문 표시
                    int next = go(board, check, nx, ny);
                    answer = Math.max(answer, next); // 최대값 구하기
                    check[board[nx].charAt(ny) - 'A'] = false; // 백트래킹
                }
            }
        }
        return answer + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String board[] = new String[n];
        for(int i = 0; i < n; i++) {
            board[i] = sc.nextLine();
        }
        boolean check[] = new boolean[26];
        check[board[0].charAt(0) - 'A'] = true; // 방문 표시
        System.out.println(go(board, check, 0, 0));
    }
}