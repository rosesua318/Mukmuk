package bfs;

import java.util.*;

public class Q16928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dist[] = new int[101];
        int next[] = new int[101];
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1; i <= 100; i++) {
            next[i] = i;
            dist[i] = -1;
        }

        for(int k = 0; k < n + m; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            next[x] = y; // 사다리, 뱀인 경우 x 도착 이후 가야할 곳 저장
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0; // 시작점 1
        while(!q.isEmpty()) { // bfs
            int x = q.poll();
            for(int i = 1; i <= 6; i++) { // 주사위 1부터 6까지
                int y = x + i;
                if(y > 100) { // 범위 넘어가는 경우
                    continue;
                }
                y = next[y]; // 다음 칸으로
                if(dist[y] == -1) { // 아직 방문하지 않은 경우
                    dist[y] = dist[x] + 1; // 거리 업데이트
                    q.add(y);
                }
            }
        }

        System.out.println(dist[100]);
    }
}