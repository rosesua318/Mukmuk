package bfs.inflearn;

import java.util.*;

public class Calf {
    public static int solution(int s, int e) {
        int check[][] = new int[2][200001];
        Queue<Integer> q = new LinkedList<>();
        check[0][s] = 1; // 0초는 짝수레벨이므로 0행에 1표시 (1행은 홀수레벨일때)
        q.offer(s);
        int L = 0; // 레벨 표시 (초의 흐름)
        while(!q.isEmpty()) {
            int len = q.size();
            L++; // 아래 for문의 자식노드인 nx의 레벨을 나타냄
            for(int i = 0; i < len; i++) {
                int x = q.poll();
                for(int nx : new int[]{x - 1, x + 1, x * 2}) {
                    if(nx >= 0 && nx <= 200000 && check[L % 2][nx] == 0) { // 범위 안이고 체크되어있지 않은 경우
                        check[L % 2][nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            e += L; // 송아지가 이동한 L만큼 더해서 위치 e 구함
            if(e > 200000) { // 범위 밖인 경우
                return - 1;
            }
            // L초에 현수가 방문할 수 있는 모든 위치는 1로 표시되어있음 -> check배열에 e의 위치가 1로 표시되어있으면 잡은것
            if(check[L % 2][e] == 1) { // L초에 현수와 송아지가 같은 위치에 있는 것이 가능한 경우
                return L; // L초 리턴
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(Calf.solution(1, 11));
        System.out.println(Calf.solution(1, 34567));
    }
}
