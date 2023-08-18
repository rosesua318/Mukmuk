package dfs.inflearn;

import java.util.ArrayList;

public class NearestNum {
    static int answer, target, m;
    static ArrayList<Integer> nums;
    static int[] check;
    static boolean flag;
    public static void DFS(int L, int number) { // L : 레벨, number : 만들어지는 숫자
        if(flag) { // 이미 가장 가까운 큰수를 찾은 경우
            return;
        }
        if(L == m) { // 모든 요소를 사용하여 숫자가 다 만들어졌을 때
            if(number > target) { // 주어진 n보다 클 때(가장 작은 n보다 큰수인 상태)
                answer = number; // 정답을 number로
                flag = true; // 가장 가까운 큰수를 만들 수 있음을 표시해줌
            }
        } else {
            for(int i = 0; i < m; i++) { // 순열 코드
                if(check[i] == 0) { // 사용하지 않은 요소인 경우
                    check[i] = 1; // 사용한다고 표시
                    DFS(L + 1, number * 10 + nums.get(i)); // 레벨 1 증가, 요소 사용한 숫자 만들어서 재귀 호출
                    check[i] = 0; // 백트래킹
                }
            }
        }
    }
    public static int solution(int n) {
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;
        while(tmp > 0) { // n을 각 자리수로 분리
            int t = tmp % 10;
            nums.add(t); // nums에 각 자리수 추가
            tmp = tmp / 10;
        }
        nums.sort((a, b) -> a - b); // DFS 순열에 의해서 숫자가 만들어지는 순서가 오름차순으로 나타나게 하기 위해
        m = nums.size();
        check = new int[m]; // 사용했는지 안했는지 여부
        DFS(0, 0); // DFS 호출
        if(flag == false) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(NearestNum.solution(123));
        System.out.println(NearestNum.solution(321));
        System.out.println(NearestNum.solution(20573));
        System.out.println(NearestNum.solution(27711));
        System.out.println(NearestNum.solution(54312));
    }
}
