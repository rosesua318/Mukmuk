package graph;

import java.util.*;

public class Q14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[][] = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        d[1][0] = 0;
        while(!q.isEmpty()) {
            int s = q.poll();
            int c = q.poll();
            if(d[s][s] == -1) { // 아직 복사 안한 경우
                d[s][s] = d[s][c] + 1;
                q.add(s); q.add(s);
            }
            if(s + c <= n && d[s + c][c] == -1) { // 아직 붙여넣기 안한 경우
                d[s + c][c] = d[s][c] + 1;
                q.add(s + c); q.add(c);
            }
            if(s - 1 >= 0 && d[s - 1][c] == -1) { // 아직 삭제 안한 경우
                d[s - 1][c] = d[s][c] + 1;
                q.add(s - 1); q.add(c);
            }
        }

        int answer = -1;
        for(int i = 0; i <= n; i++) {
            if(d[n][i] != -1) {
                if(answer == -1 || answer > d[n][i]) {
                    answer = d[n][i];
                }
            }
        }
        System.out.println(answer);
    }
}