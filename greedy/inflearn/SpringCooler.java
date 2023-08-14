package greedy.inflearn;

import java.util.Arrays;

public class SpringCooler {
    public static int solution(int n, int[] nums) {
        int answer = 0;
        int line[][] = new int[nums.length + 1][2]; // [index][index - nums[index]] & [index][index + nums[index]] : 각 위치에서 물을 뿌리는 범위 저장
        for(int i = 0; i <= n; i++) {
            line[i][0] = Math.max(0, i - nums[i]); // 음수가 나오지 않도록
            line[i][1] = Math.min(n, i + nums[i]); // n을 넘어서지 않도록
        }
        Arrays.sort(line, (a, b) -> a[0] - b[0]); // 위치에 대해서 오름차순 정렬
        int start = 0, end = 0, i = 0;
        while(i < line.length) {
            while(i < line.length && line[i][0] <= start) {
                end = Math.max(end, line[i][1]); // end 값 업데이트
                i++; // 인덱스 증가
            }
            answer++; // 해당 스프링쿨러 사용한다는 뜻으로 1 증가하기
            if(end == n) { // 물을 끝까지 뿌릴 수 있는 경우
                return answer; // 개수 리턴
            }
            if(start == end) { // 중간에 이어지지 않고 끊기는 경우
                return -1;
            }
            start = end; // start를 end값으로 업데이트해주기
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(SpringCooler.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(SpringCooler.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(SpringCooler.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(SpringCooler.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
