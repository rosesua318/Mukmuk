package brute_force.recursion;

import java.util.*;

public class Q16198 {
    static int go(ArrayList<Integer> a) {
        int n = a.size();
        if(n == 2) { // 불가능한 경우
            return 0;
        }
        int answer = 0;
        for(int i = 1; i < n - 1; i++) {
            int energy = a.get(i - 1) * a.get(i + 1); // 에너지 계산
            ArrayList<Integer> b = new ArrayList<>(a);
            b.remove(i); // 현재 구슬 제거
            energy += go(b); // 다음 경우
            answer = Math.max(answer, energy); // 최댓값 구하기
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        System.out.println(go(a));
    }
}