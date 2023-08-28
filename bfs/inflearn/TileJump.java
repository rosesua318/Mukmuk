package bfs.inflearn;

import java.util.*;

public class TileJump {
    public static int solution(int[] nums) {
        int n = nums.length;
        int check[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // 시작점 추가
        check[0] = 1;
        int L = 0; // 레벨 (몇번만에 도달가능한지)
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) { // 현재 L레벨인 값들 모두 탐색
                int x = q.poll();
                for(int j = 1; j <= nums[x]; j++) { // 자식노드인 L+1레벨들을 탐색
                    int nx = x + j;
                    if(nx == n - 1) { // 자식노드인 L+1레벨 노드가 상점에 도달한 경우
                        return L + 1; // 자식노드의 레벨 리턴해주기
                    }
                    if(nx < n && check[nx] == 0) { // 아직 방문하지 않은 경우
                        check[nx] = 1; // 방문 체크
                        q.offer(nx); // 큐에 넣기
                    }
                }
            }
            // 이중 for문 다돌고나면 L+1레벨의 노드들만 큐에 남아있기 때문에 L을 증가시켜서 현재 레벨을 L+1로 만들어줌
            L++;
        }
        return -1;
    }
    public static void main (String[] args) {
        System.out.println(TileJump.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(TileJump.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
    }
}
