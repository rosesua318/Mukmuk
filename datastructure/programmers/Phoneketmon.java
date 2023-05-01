package datastructure.programmers;

import java.util.*;

public class Phoneketmon {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int n = nums.length / 2;
        if(set.size() > n) { // 가질 수 있는 폰켓몬 수 보다 많은 경우
            answer = n; // 가장 많은 종류의 수는 가질 수 있는 폰켓몬 수가 된다.
        } else { // 작은 경우
            answer = set.size(); // 종류의 수는 set의 size와 같다.
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 3 };
        Phoneketmon c = new Phoneketmon();
        System.out.println(c.solution(nums));
    }
}