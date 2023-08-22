package dfs.inflearn;

import java.util.ArrayList;

// 조합 문제
public class Baduk {
    static int n, answer = 1000000000;
    static int[] check;
    public static void DFS(int L, int s, int[][] cans) {
        if(L == n / 2) { // 팀이 만들어진 경우
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(check[i] == 1) { // A팀 소속인 경우
                    a.add(i); // 인덱스 저장
                } else {
                    b.add(i); // 인덱스 저장
                }
            }
            int asum = 0, bsum = 0;
            for(int i = 0; i < L; i++) {
                asum += cans[a.get(i)][0]; // A팀의 능력치 총합 구하기
                bsum += cans[b.get(i)][1]; // B팀의 능력치 총합 구하기
            }
            answer = Math.min(answer, Math.abs(asum - bsum)); // 능력차의 최솟값 구하기
        } else {
            for(int i = s; i < n; i++) { // 조합 코드
                check[i] = 1; // A팀으로 배정
                DFS(L + 1, i + 1, cans); // 다음단계 가지뻗기
                check[i] = 0;
            }
        }
    }
    public static int solution(int[][] cans) {
        n = cans.length;
        check = new int[n];
        DFS(0, 0, cans);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Baduk.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
    }
}
