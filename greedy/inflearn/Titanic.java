package greedy.inflearn;

import java.util.Arrays;

public class Titanic {
    public static int solution(int[] nums, int m) {
        int answer = 0;
        Arrays.sort(nums); // 무게 기준으로 오름차순 정렬
        int left = 0; // 가장 가벼운 사람
        int right = nums.length - 1; // 가장 무거운 사람
        while(left <= right) { // 같아지는 순간도 넣어야함(1명만 남은 경우가 있기 때문에)
            if(nums[left] + nums[right] <= m) { // 가장 무거운 사람과 가벼운 사람의 합이 m 이하일 때
                answer++; // 보트의 개수 1 증가
                left++;
                right--;
            } else { // m 보다 클 때
                answer++; // 보트의 개수 1 증가
                right--; // 무거운 사람만 태워보냈으므로
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Titanic.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(Titanic.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
    }
}
