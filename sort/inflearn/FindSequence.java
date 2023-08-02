package sort.inflearn;

import java.util.*;

public class FindSequence {
    public static int[] solution(int[] nums) {
        int answer[] = new int[nums.length / 2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Arrays.sort(nums); // 오름차순 정렬
        int index = 0;
        for(int x : nums) {
            if(map.get(x) == 0) { // 개수가 0이면 이미 지워진 것이므로 패스
                continue;
            }
            answer[index] = x; // 현재 배열에서 가장 작은 수 answer에 넣기
            index++;
            map.put(x, map.get(x) - 1); // 가장 작은 수의 개수 1 빼기
            map.put(x * 2, map.get(x * 2) - 1); // 가장 작은 수에 2배한 값의 개수 1 빼기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(FindSequence.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
