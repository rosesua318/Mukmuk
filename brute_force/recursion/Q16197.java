package brute_force.recursion;

import java.util.*;

public class Q16197 {
    static int n, m;
    static char a[][];
    static final int dx[] = { 0, 0, 1, -1 };
    static final int dy[] = { 1, -1, 0, 0 };
    static int go(int step, int x1, int y1, int x2, int y2) {
        if(step == 11) { // 불가능한 경우
            return -1;
        }
        boolean fall1 = false; // 동전1이 떨어졌는지 여부
        boolean fall2 = false; // 동전2가 떨어졌는지 여부
        if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) { // 범위 밖인 경우
            fall1 = true; // 동전1 떨어짐
        }
        if(x2 < 0 || x2 >= n || y2 < 0 || y2 >= m) { // 범위 밖인 경우
            fall2 = true; // 동전2 떨어짐
        }

        if(fall1 && fall2) { // 두 동전 모두 떨어진 경우
            return -1;
        }
        if(fall1 || fall2) { // 한 동전만 떨어진 경우
            return step; // 최소값 리턴
        }

        int answer = -1;
        for(int k = 0; k < 4; k++) { // 상하좌우 이동
            int nx1 = x1 + dx[k];
            int ny1 = y1 + dy[k];
            int nx2 = x2 + dx[k];
            int ny2 = y2 + dy[k];
            if(0 <= nx1 && nx1 < n && 0 <= ny1 && ny1 < m && a[nx1][ny1] == '#') { // 이동할 칸이 벽인 경우
                nx1 = x1; // 이동 안함
                ny1 = y1;
            }
            if(0 <= nx2 && nx2 < n && 0 <= ny2 && ny2 < m && a[nx2][ny2] == '#') {
                nx2 = x2; // 이동 안함
                ny2 = y2;
            }

            int temp = go(step + 1, nx1, ny1, nx2, ny2);
            if(temp == -1) { // 불가능한 경우
                continue;
            }
            if(answer == -1 || answer > temp) {
                answer = temp; // 최소값 구하기
            }
        }
        return answer;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        int x1, y1, x2, y2;
        x1 = y1 = x2 = y2 = -1;
        for(int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 'o') {
                    if(x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                    a[i][j] = '.';
                }
            }
        }
        System.out.println(go(0, x1, y1, x2, y2));
    }
}