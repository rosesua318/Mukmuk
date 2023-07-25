package datastructure.inflearn;

import java.util.HashSet;

public class MCNSS {
    public static int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) {
            set.add(x); // 중복 제거하며 추가
        }
        for(int x : set) {
            if(set.contains(x - 1)) { // 현재 수보다 1 작은 수가 있는 경우
                continue; // 탐색할 필요 없음 (1 작은 수부터 탐색해야 하기 때문)
            }
            int count = 0;
            while(set.contains(x)) { // 수가 set에 있을 때 까지
                count++; // 수열 길이 증가
                x++; // 수 증가
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(MCNSS.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(MCNSS.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(MCNSS.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(MCNSS.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(MCNSS.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
