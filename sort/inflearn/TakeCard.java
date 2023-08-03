package sort.inflearn;

import java.util.Arrays;

public class TakeCard {
    public static int solution(int[] nums, int k) {
        int answer = 0;
        int n = nums.length;
        Integer[] tmp = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, (a, b) -> b - a); // 카드들을 내림차순으로 정렬
        Integer[] diff = new Integer[n / 2]; // 라운드별 점수 차이 저장하는 배열
        for(int i = 0; i < n / 2; i++) {
            answer += tmp[i * 2 + 1]; // 매라운드에서 현수가 받을 수 있는 점수들 더하기
            diff[i] = tmp[i * 2] - tmp[i * 2 + 1]; // 매 라운드 점수 차이 계산
        }
        Arrays.sort(diff, (a, b) -> b - a); // 점수 차를 기준으로 내림차순 정렬
        for(int i = 0; i < k; i++) { // k번
            answer += diff[i]; // 점수 차이 더하기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(TakeCard.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(TakeCard.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
    }
}
