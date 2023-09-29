package backtracking.recursion;

import java.util.*;

// 백준 14889번 스타트와 링크
public class Q14889{
    static int s[][];
    static int n;
    static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
        if(index == n) { // 모든 사람을 팀에 추가한 경우
            if(first.size() != n / 2) { // first팀의 사람 수가 n/2가 아닌 경우
                return -1; // -1을 리턴하여 정답에서 제외 시킴
            }
            if(second.size() != n / 2) { // second팀의 사람 수가 n/2가 아닌 경우
                return -1; // -1을 리턴하여 정답에서 제외 시킴
            }
            int t1 = 0; // 1번 팀의 능력치
            int t2 = 0; // 2번 팀의 능력치
            for(int i = 0; i < n / 2; i++) { // 사람 당 모든 쌍에 대해서 탐색
                for(int j = 0; j < n / 2; j++) {
                    if(i == j) { // 동일 인물과 동일 인물의 능력치인 경우 의미 없으므로
                        continue; // 건너뛰기
                    }
                    t1 += s[first.get(i)][first.get(j)]; // 각 팀원 별로 상대방과의 능력치들을 1번팀의 능력치로 더해주기
                    t2 += s[second.get(i)][second.get(j)]; // 각 팀원 별로 상대방과의 능력치들을 2번팀의 능력치고 더해주기
                }
            }
            return Math.abs(t1 - t2); // 차이를 절댓값을 리턴해주기
        }

        // 정답이 없을 것 같은 경우에 바로 탐색을 종료하므로 브루트포스가 아닌 백트래킹 알고리즘이다.
        if(first.size() > n / 2 || second.size() > n / 2) { // 모든 사람을 팀에 넣기도 전에 어느 한팀의 사람 수가 n/2보다 많아진 경우
            return -1; // -1을 리턴하여 정답에서 제외 시킴
        }

        int answer = -1;

        // index번째 사람을 1번 팀에 넣는 작업
        first.add(index); // index번째 사람을 first에 넣어주기
        int t1 = go(index + 1, first, second); // 각 팀의 능력치 차이값 구하기 위해 재귀함수 호출
        if(answer == -1 || (t1 != -1 && answer > t1)) { // 차이값이 구해졌고 최소값인 경우
            answer = t1; // answer에 t1 대입해주기
        }
        first.remove(first.size() - 1); // index번째 사람 바로 다음에는 2번 팀에 들어가는 작업 해봐야 하니까 first 팀에서 빼주기

        // index번째 사람을 2번 팀에 넣는 작업
        second.add(index); // index번째 사람을 second에 넣어주기
        int t2 = go(index + 1, first, second); // 각 팀의 능력치 차이값 구하기 위해 재귀함수 호출
        if(answer == -1 || (t2 != -1 && answer > t2)) { // 차이값이 구해졌고 최소값인 경우
            answer = t2; // answer에 t2 대입해주기
        }
        second.remove(second.size() - 1); // 작업이 끝났으니까 second 팀에서 빼주기

        return answer; // 차이의 최소값 리턴해주기
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        System.out.println(go(0, first, second));
    }
}