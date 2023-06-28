package bfs;

import java.util.*;

public class Q9019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean check[] = new boolean[10001];
            int dist[] = new int[10001];
            char how[] = new char[10001];
            int from[] = new int[10001];

            Queue<Integer> q = new LinkedList<Integer>();
            q.add(n); // 시작점은 초기 숫자
            check[n] = true;
            dist[n] = 0;
            from[n] = -1;

            while(!q.isEmpty()) { // bfs
                int now = q.poll();

                // D 연산
                int next = (now * 2) % 10000;
                if(check[next] == false) { // 방문하지 않은 경우
                    q.add(next);
                    check[next] = true;
                    dist[next] = dist[now] + 1; // 연산 횟수 업데이트
                    from[next] = now; // now에서 D연산을 통해 next가 만들어짐
                    how[next] = 'D'; // 전 단계에서 D연산을 통해 만들어짐
                }

                // S 연산
                next = now - 1;
                if(next == -1) {
                    next = 9999;
                }
                if(check[next] == false) { // 방문하지 않은 경우
                    q.add(next);
                    check[next] = true;
                    dist[next] = dist[now] + 1; // 연산 횟수 업데이트
                    from[next] = now; // now에서 S연산을 통해 next가 만들어짐
                    how[next] = 'S'; // 전 단계에서 S연산을 통해 만들어짐
                }

                // L 연산
                next = (now % 1000) * 10 + now / 1000;
                if(check[next] == false) { // 방문하지 않은 경우
                    q.add(next);
                    check[next] = true;
                    dist[next] = dist[now] + 1; // 연산 횟수 업데이트
                    from[next] = now; // now에서 L연산을 통해 next가 만들어짐
                    how[next] = 'L'; // 전 단계에서 L연산을 통해 만들어짐
                }

                // R 연산
                next = (now % 10) * 1000 + (now / 10);
                if(check[next] == false) { // 방문하지 않은 경우
                    q.add(next);
                    check[next] = true;
                    dist[next] = dist[now] + 1; // 연산 횟수 업데이트
                    from[next] = now; // now에서 R연산을 통해 next가 만들어짐
                    how[next] = 'R'; // 전 단계에서 R연산을 통해 만들어짐
                }
            }

            StringBuilder answer = new StringBuilder();
            while(m != n) { // 역추적
                answer.append(how[m]);
                m = from[m];
            }
            System.out.println(answer.reverse());
        }
    }
}