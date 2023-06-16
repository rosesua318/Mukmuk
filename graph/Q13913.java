package graph;

import java.util.*;

public class Q13913 {
    public static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean check[] = new boolean[MAX];
        int dist[] = new int[MAX];
        int from[] = new int[MAX];
        check[n] = true;
        dist[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while(!q.isEmpty()) {
            int now = q.poll();
            if(now - 1 >= 0) { // 현재 위치에서 -1 했을 때 가능한 경우
                if(check[now - 1] == false) { // 아직 방문하지 않은 경우
                    q.add(now - 1);
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1; // 시간 +1
                    from[now - 1] = now;
                }
            }
            if(now + 1 < MAX) { // 현재 위치에서 +1 했을 때 가능한 경우
                if(check[now + 1] == false) { // 아직 방문하지 않은 경우
                    q.add(now + 1);
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1; // 시간 +1
                    from[now + 1] = now;
                }
            }
            if(now * 2 < MAX) { // 현재 위치에서 *2 했을 때 가능한 경우
                if(check[now * 2] == false) { // 아직 방문하지 않은 경우
                    q.add(now * 2);
                    check[now * 2] = true;
                    dist[now * 2] = dist[now] + 1; // 시간 +1
                    from[now * 2] = now;
                }
            }
        }
        System.out.println(dist[m]);

        Stack<Integer> answer = new Stack<>();
        for(int i = m; i != n; i = from[i]) {
            answer.push(i);
        }
        answer.push(n);
        while(!answer.isEmpty()) {
            System.out.print(answer.pop() + " ");
        }
        System.out.println();
    }
}