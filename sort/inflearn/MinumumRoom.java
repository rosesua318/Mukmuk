package sort.inflearn;

import java.util.ArrayList;

public class MinumumRoom {
    public static int solution(int[][] meetings) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : meetings) {
            list.add(new int[]{x[0], 1}); // 시작 시간은 1
            list.add(new int[]{x[1], 2}); // 끝나는 시간은 2로 구분
        }
        list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]); // 시간이 같으면 끝나는 시간을 우선으로 정렬
        int answer = 0, count = 0;
        for(int[] x : list) {
            if(x[1] == 1) { // 시작 시간인 경우
                count++; // 회의실 개수 추가
            } else { // 끝나는 시간인 경우
                count--; // 회의실 개수 감소
            }
            answer = Math.max(answer, count); // 매번 최댓값 확인하기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(MinumumRoom.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(MinumumRoom.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
