package sort.inflearn;

import java.util.Arrays;

public class BinarySort {
    public static int[] solution(int[] nums) {
        int answer[] = new int[nums.length];
        int res[][] = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            int tmp = nums[i];
            while(tmp > 0) {
                count += (tmp % 2); // 1의 개수 구하기
                tmp /= 2;
            }
            res[i][0] = nums[i];
            res[i][1] = count;
        }

        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // 1의 개수로 정렬. 같으면 십진수 기준 오름차순으로
        for(int i = 0; i < res.length; i++) {
            answer[i] = res[i][0];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(BinarySort.solution(new int[]{5, 6, 7, 8, 9})));
    }
}
