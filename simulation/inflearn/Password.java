package simulation.inflearn;

import java.util.Arrays;

public class Password {
    static public int solution(int[] keypad, String password) {
        int answer = 0;
        int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int pad[][] = new int[3][3];
        int dist[][] = new int[10][10];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }
        for(int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2); // 2로 초기화
        }
        for(int i = 0; i < 10; i++) {
            dist[i][i] = 0; // 자기 자신은 0초로
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for(int k = 0; k < 8; k++) { // 8방향 탐색
                    if(i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) { // 범위 안인 경우
                        int to = pad[i + dx[k]][j + dy[k]];
                        dist[from][to] = 1; // 걸리는 시간 1초로 업데이트
                    }
                }
            }
        }
        for(int i = 1; i < password.length(); i++) {
            int from = (int) password.charAt(i - 1) - 48;
            int to = (int) password.charAt(i) - 48;
            answer += dist[from][to];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Password.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
    }
}
