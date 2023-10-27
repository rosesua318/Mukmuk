package simulation.samsung;

import java.io.*;
import java.util.*;

public class Q3190 {
    static int[][] board;
    static Queue<Integer> q = new LinkedList<>(); // 뱀의 몸통 정보
    static int n, k, l;
    static HashMap<Integer, String> map = new HashMap<>(); // (뱀의 방향 변환 시간, 방향 변환 정보)
    static int dx[] = {0, 1, 0, -1}; // 동 남 서 북
    static int dy[] = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); // 보드 크기
        k = Integer.parseInt(br.readLine()); // 사과 개수
        board = new int[n][n];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            board[a][b] = 1; // 사과 위치에 1 표시
        }
        l = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 정보 개수
        for(int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            map.put(x, c); // 방향 변환 정보 해시맵에 저장
        }

        int cx = 0, cy = 0; // 뱀의 위치
        int time = 0; // 걸린 시간
        int d = 0; // 방향 정보
        q.add(0); // 뱀의 시작점 넣기
        while(true) {
            // 시간 재기
            time++;

            // 뱀 이동하기
            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) { // 범위 벗어나는 경우
                break; // 멈추기
            }
            if(q.contains(ny * n + nx)) { // 뱀 몸통이 부딪히는 경우
                break;
            }

            if(board[nx][ny] == 1) { // 사과가 있는 경우
                board[nx][ny] = 0; // 사과 없애기
                q.add(ny * n + nx); // 뱀 몸통 넣기
            } else {
                q.add(ny * n + nx); // 뱀 몸통 넣기
                q.poll(); // 꼬리 위치한 칸 정보 빼기
            }

            if(map.containsKey(time)) { // 방향 변환 시간인 경우
                if(map.get(time).equals("D")) { // 오른쪽으로 90도 방향 회전인 경우
                    d = (d + 1) % 4; // 오른쪽으로 90도 회전
                } else { // 왼쪽으로 90도 방향 회전인 경우
                    d -= 1;
                    if(d == -1) {
                        d = 3;
                    }
                }
            }

            // 현재 값을 이동할 값으로 업데이트
            cx = nx;
            cy = ny;
        }
        System.out.println(time); // 시간 출력
    }
}
