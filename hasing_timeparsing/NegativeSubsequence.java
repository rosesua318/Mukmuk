package hasing_timeparsing;

import java.util.HashMap;

public class NegativeSubsequence {
    public static int solution(int[] nums, int m) {
        int answer = 0;
        HashMap<Integer, Integer> nh = new HashMap<>();
        int sum = 0;
        nh.put(0, 1);
        for(int x : nums) {
            sum += x;
            if(nh.containsKey(sum - m)) {
                answer += nh.get(sum - m);
            }
            nh.put(sum, nh.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(NegativeSubsequence.solution(new int[]{1, 1, 2, 3, -2, 1, 2, 2, -3}, 5));
    }
}
