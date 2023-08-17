package greedy.inflearn;

import java.util.*;

public class MaxPeople {
    public static int solution(int n, int[][] trans, int[][] bookings) {
        int answer = 0;
        int sum[] = new int[n + 1];
        for(int[] x : trans) {
            sum[x[0]] += x[2]; // 승차역에서는 수용인원만큼 더해주기
            sum[x[1]] -= x[2]; // 하차역에서는 수용인원만큼 빼주기
        }
        for(int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1]; // 누적합 구하기 -> 각 역마다 최대수용인원 나옴
        }

        int bn = bookings.length;
        Arrays.sort(bookings, (a, b) -> a[0] - b[0]); // 승차역을 기준으로 오름차순 정렬(빨리 타는 순으로 정렬)
        LinkedList<Integer> nums = new LinkedList<>();
        int idx = 0; // bookings를 탐색하기 위한 인덱스
        for(int i = 1; i <= n; i++) { // i는 역번호를 탐색
            while(!nums.isEmpty() && nums.peek() == i) { // 현재 역에서 내릴 수 있는 사람이 있을 때 까지 반복
                answer++; // 예약 받을 수 있는 카운트 증가시키기(내리기 때문에 받기 가능)
                nums.pollFirst(); // 내리기
            }
            while(idx < bn && bookings[idx][0] == i) { // 현재역에서 승차할 수 있는 사람이 있을 때까지 반복
                nums.add(bookings[idx][1]); // 태우기(어린이의 하차역 넣기)
                idx++; // 인덱스 증가
            }

            // 그리디 핵심 코드
            Collections.sort(nums); // 도착역을 기준으로 오름차순 정렬
            while(nums.size() > sum[i]) { // 수용인원보다 타는인원이 많은경우 반복
                nums.pollLast(); // 도착역이 가까운 어린이부터 기차에 태우기 위해 도착역이 먼것부터 빼내기
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(MaxPeople.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 5}, {2, 4}, {2, 5}, {2, 3}, {3, 5}, {3, 4}}));
    }
}
