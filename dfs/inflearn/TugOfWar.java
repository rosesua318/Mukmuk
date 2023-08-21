package dfs.inflearn;

import java.util.Stack;

public class TugOfWar {
    static int[] check;
    static int[][] relation;
    static int answer;
    static Stack<Integer> pm;
    public static void DFS(int L) {
        if(L == 7) { // 줄 세우기 완료된 경우
            answer++; // 경우의 수 증가
        } else {
            for(int i = 1; i < 8; i++) {
                if(!pm.isEmpty() && relation[pm.peek()][i] == 1) { // 앞의 사람과 현재 사람의 관계가 안 좋은 경우
                    continue; // 줄 세우기 중단하고 다음 경우로 넘어가기
                }
                if(check[i] == 0) { // 아직 세우지 않은 사람인 경우
                    check[i] = 1; // 세웠다고 표시
                    pm.push(i); // 줄 세우기
                    DFS(L + 1); // 뒷 사람 세우기 위해 호출
                    check[i] = 0; // 백트래킹
                    pm.pop();
                }
            }
        }
    }
    public static int solution(int[][] fight) {
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8]; // 7행 7열 만들기
        for(int[] x : fight) { // 싫어하는 관계들 양방향으로 표시
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        check = new int[8]; // 방문 배열 생성
        DFS(0); // DFS 함수 호출
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(TugOfWar.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(TugOfWar.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
    }
}
