package dfs.inflearn;

import java.util.*;

// 조합 이용
public class PizzaDelivery {
    static class Point {
        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int m;
    static int len; // 피자집의 개수
    static int answer = Integer.MAX_VALUE; // 도시의 피자배달거리 최소값
    static int[] combi; // 만들어지는 피자 가게 조합 저장
    static ArrayList<Point> hs, pz; // 집 좌표 저장, 피자가게 좌표 저장

    public static void DFS(int L, int s) {
        if(L == m) { // 조합이 1개 완성된 경우
            int sum = 0; // 해당 조합에서 도시의 피자배달거리
            for(Point h : hs) { // 각 집 하나하나 대응
                int dis = Integer.MAX_VALUE; // 각 집의 피자배달거리
                for(int i : combi) { // 조합에 속한 피자가게 하나하나 대응
                    // 집 피자배달거리 구하기 위해 집과 피자가게 사이 거리 중에서 가장 최소값 찾기
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis; // 각 집의 피자배달거리 더해줘서 해당 조합에서의 도시 피자배달거리 구하기
            }
            answer = Math.min(answer, sum); // 최소 도시 피자배달거리를 구하기 위해 해당 조합에서 구한 도시 피자배달거리가 더 작은 경우 업데이트해주기
        } else {
            for(int i = s; i < len; i++) { // 조합 만들기
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static int solution(int n, int pc, int[][] map) {
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) { // 집인 경우
                    hs.add(new Point(i, j)); // 집 좌표 저장
                } else if(map[i][j] == 2) { // 피자 가게인 경우
                    pz.add(new Point(i, j)); // 피자 가게 좌표 저장
                }
            }
        }
        m = pc; // 선택할 피자가게 개수
        len = pz.size(); // 피자집 개수 저장
        combi = new int[m]; // lenCm의 조합을 생성하게 됨
        DFS(0, 0);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(PizzaDelivery.solution(4, 4, new int[][]{{0, 1, 2, 0}, {1, 0, 2, 1}, {0, 2, 1, 2}, {2, 0, 1, 2}}));
    }
}