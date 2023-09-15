package graph.inflearn;

import java.util.*;

public class TransferRoute {
    public static int solution(int[][] routes, int s, int e) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>(); // key는 역번호, value는 역번호에 연결되어있는 호선들로 이루어진 HashSet
        int n = routes.length;
        for(int i = 0; i < n; i++) { // 각 호선들 정보 탐색
            for(int x : routes[i]) { // i 호선의 역번호들 탐색
                graph.putIfAbsent(x, new HashSet<Integer>()); // x 역번호가 없을 때 새로 생성
                graph.get(x).add(i); // x 역번호와 연결된 i 호선 삽입
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int check[] = new int[n]; // 호선 탐색했는지 여부
        q.offer(s); // 처음역 삽입
        int L = 0; // 환승 횟수
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int curStop = q.poll(); // 출발역
                for(int line : graph.get(curStop)) { // 출발역에 연결된 호선들
                    if(check[line] == 1) { // 이미 탐색했던 호선인 경우
                        continue; // 넘어가기
                    }
                    check[line] = 1; // 호선 탐색했다고 표시
                    for(int stop : routes[line]) { // 해당 호선의 노선에 있는 역들
                        if(stop == e) { // 도착역이 발견된 경우
                            return L; // 레벨(환승횟수) 리턴해주기
                        }
                        q.offer(stop); // 역번호들 자식 노드로 집어넣기
                    }
                }
            }
            L++; // 환승횟수 증가
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(TransferRoute.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
    }
}
