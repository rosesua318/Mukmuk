package bfs;

import java.util.*;

public class Q13549 {
    public static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean c[] = new boolean[MAX];
        int d[] = new int[MAX];
        c[n] = true;
        d[n] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(n);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : new int[]{now * 2, now - 1, now + 1}) {
                if(next >= 0 && next < MAX) {
                    if(c[next] == false) {
                        c[next] = true;
                        if(next == now * 2) { // 순간이동하는 경우
                            q.addFirst(next);
                            d[next] = d[now]; // 0초 걸림
                        } else {
                            q.addLast(next);
                            d[next] = d[now] + 1; // 1초 걸림
                        }
                    }
                }
            }
        }
        System.out.println(d[m]);
    }
}