package bfs.inflearn;

import java.util.*;

public class GoHome {
    public static int solution(int[] pool, int a, int b, int home) {
        int check[][] = new int[2][10001]; // 0 : 앞으로 점프, 1 : 뒤로 점프
        for(int x : pool) { // pool 인 부분은 방문 할 수 없도록 모두 1로 표시
            check[0][x] = 1;
            check[1][x] = 1;
        }
        Queue<int[]> q = new LinkedList<>();
        check[0][0] = 1; // 시작점 표시
        check[1][0] = 1;
        q.offer(new int[]{0, 0});
        int L = 0; // 레벨
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) { // 현재 L레벨인 값들 모두 탐색
                int cur[] = q.poll();
                if(cur[0] == home) { // 현재 위치가 집에 도달한 경우
                    return L; // 점프 횟수 리턴
                }
                int nx = cur[0] + a; // 현재 위치에서 앞으로 점프
                if(nx <= 10001 && check[0][nx] == 0) { // 범위 안이면서 방문하지 않은 경우
                    check[0][nx] = 1; // 방문 표시
                    q.offer(new int[]{nx, 0}); // 앞으로 점프했으므로 순서쌍에 0 넣기
                }
                nx = cur[0] - b; // 현재 위치에서 뒤로 점프
                if(nx >= 0 && check[1][nx] == 0 && cur[1] == 0) { // 범위 안이면서 방문하지 않았으며 두번 연속 뒤로 점프가 아닌 경우
                    check[1][nx] = 1;
                    q.offer(new int[]{nx, 1}); // 뒤로 점프했으므로 순서쌍에 1 넣기
                }
            }
            // 이중 for문 다돌고나면 L+1레벨의 노드들만 큐에 남아있기 때문에 L을 증가시켜서 현재 레벨을 L+1로 만들어줌
            L++;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(GoHome.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(GoHome.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(GoHome.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
    }
}
