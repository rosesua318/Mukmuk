package graph;

import java.util.*;

public class Q16947 {
    static ArrayList<Integer>[] a;
    static int check[];
    static int dist[];
    static int go(int x, int p) {
        // -2 : 사이클을 찾았지만, 포함되지 않은 경우
        // -1 : 사이클을 찾지 못한 경우
        // 0~n-1 : 사이클을 찾았고 사이클의 시작점
        if(check[x] == 1) { // 사이클을 찾은 경우
            return x; // 시작점을 리턴
        }
        check[x] = 1;
        for(int y : a[x]) {
            if(y == p) { // 이미 방문한 경우
                continue;
            }
            int res = go(y, x);
            if(res == -2) { // 사이클에 포함되지 않는 경우
                return -2;
            }
            if(res >= 0) { // 사이클에 포함되는 경우
                check[x] = 2; // 사이클의 일부임을 표시
                if(x == res) { // 한바퀴 돌아서 사이클의 시작점에 도달
                    return -2; // 다음 정점부터는 사이클이 아님
                } else {
                    return res;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList[n];
        dist = new int[n];
        check = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            a[u].add(v);
            a[v].add(u);
        }
        go(0, -1); // 순환선 찾기
        // 각 역들의 순환선과 거리 찾기(bfs)
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(check[i] == 2) { // 순환선에 포함된 정점인 경우
                dist[i] = 0;
                q.add(i);
            } else {
                dist[i] = -1;
            }
        }
        while(!q.isEmpty()) {
            int x = q.poll();
            for(int y : a[x]) {
                if(dist[y] == -1) { // 순환선에 포함되어 있지 않고, 계산되지 않은 경우
                    q.add(y);
                    dist[y] = dist[x] + 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}