package simulation.inflearn;

import java.util.ArrayList;

public class BitonicSequence {
    static public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>(); // 봉우리 지점 저장
        for(int i = 1; i < n - 1; i ++) {
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) { // 봉우리 찾기
                peaks.add(i);
            }
        }
        for(int x : peaks) {
            int left = x;
            int right = x;
            int count = 1; // 길이
            while(left - 1 >= 0 && nums[left - 1] < nums[left]) { // 감소하는 부분일 때 까지 (왼쪽)
                left--;
                count++; // 길이 증가
            }
            while(right + 1 < n && nums[right] > nums[right + 1]) { // 감소하는 부분일 때 가지 (오른쪽)
                right++;
                count++; // 길이 증가
            }
            answer = Math.max(answer, count); // 최장 길이 찾기
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(BitonicSequence.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(BitonicSequence.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(BitonicSequence.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(BitonicSequence.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
