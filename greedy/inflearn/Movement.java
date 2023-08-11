package greedy.inflearn;

import java.util.Arrays;

public class Movement {
    public static int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums); // 무게를 기준으로 오름차순 정렬
        int left = 0; // 가장 가벼운 것 가리킴
        int right = nums.length - 1; // 가장 무거운 것 가리킴
        while(left <= right) { // 엇갈릴 때까지
            if(nums[left] + nums[right] <= 5) { // 가장 가벼운것과 가장 무거운것의 합이 5 이하인경우
                answer++; // 이동횟수 증가
                left++;
                right--;
            } else { // 5를 넘어가는 경우 -> 가장 무거운것만 옮기기
                answer++; // 이동횟수 증가
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Movement.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(Movement.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
