package graph.inflearn;

import java.util.*;

public class Airfare {
    public static int solution(int n, int[][] flights, int s, int e, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>(); // 인접리스트
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int costs[] = new int[n]; // 출발도시에서 i번 도시까지 가는데 드는 최소 비용
        Arrays.fill(costs, 1000000000); // 큰 값으로 채우기
        for(int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
        }
        Queue<int[]> q = new LinkedList<>(); // 환승의 횟수 순서대로 방문을 해야 하기 때문에 레벨탐색
        q.offer(new int[]{s, 0});
        costs[s] = 0;
        int L = 0;
        while(!q.isEmpty()) { // 레벨 탐색
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int p[] = q.poll();
                int now = p[0];
                int nowcost = p[1];
                for(int[] x : graph.get(now)) { // 현재 도시에서 갈 수 있는 도시 정보 탐색
                    int next = x[0];
                    int cost = x[1];
                    if(nowcost + cost < costs[next]) { // 출발 도시에서 현재 도시까지 비용 + 현재 도시에서 next까지 비용이 기존 출발도시에서 next까지 가는 최소 비용 보다 작은 경우
                        costs[next] = nowcost + cost; // 출발 도시에서 next까지 가는 최소 비용 업데이트 해주기
                        q.offer(new int[]{next, costs[next]});
                    }
                }
            }
            L++; // 레벨 증가
            if(L > k) { // L값이 K보다 커지는 순간이 K번 환승한 순간이므로(L - 1 값이 환승횟수임) break해줌
                break;
            }
        }
        if(costs[e] == 1000000000) { // 출발 도시에서 e까지 경로가 없거나 K번 환승해서는 못가는 경우
            return -1;
        } else { // 갈 수 있는 경우
            return costs[e]; // 최소 비용 리턴
        }
    }
    public static void main(String[] args) {
        System.out.println(Airfare.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(Airfare.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
    }
}
