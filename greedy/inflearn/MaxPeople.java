package greedy.inflearn;

import java.util.*;

public class MaxPeople {
    public static int solution(int n, int[][] trans, int[][] bookings) {
        int answer = 0; // 최대 예약 받을 수 있는 어린이수
        int sum[] = new int[n + 1]; // sum[i]: i번 역에서 다음 역으로 가기까지 태울 수 있는 수용인원수
        for(int[] x : trans) { // 기차 탐색하면서
            sum[x[0]] += x[2]; // 승차역에서는 기차의 수용인원만큼 더해주기
            sum[x[1]] -= x[2]; // 하차역에서는 기차의 수용인원만큼 빼주기
        }
        for(int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1]; // 누적합 구하기 -> 각 역마다 최대수용인원 나옴
        }

        int bn = bookings.length; // 예약한 어린이 명수
        Arrays.sort(bookings, (a, b) -> a[0] - b[0]); // 어린이 예약정보에서 >>승차역<<이 빠른 순서대로 오름차순 정렬
        LinkedList<Integer> nums = new LinkedList<>(); // 운행하고 있는 1개의 기차 - 어린이를 태우고 내리게 함(여러 대지만 한대로 간주)
        int idx = 0; // bookings를 탐색하기 위한 인덱스
        for(int i = 1; i <= n; i++) { // 역번호를 탐색 (1번부터 n번역까지 탐색)
            while(!nums.isEmpty() && nums.peek() == i) { // 현재 역에서 하차할 사람이 기차 안에 있을 때 까지 반복
                answer++; // 예약 받을 수 있는 카운트 증가시키기(하차하기 때문에 예약 받기 가능)
                nums.pollFirst(); // 어린이 내리기
            }
            while(idx < bn && bookings[idx][0] == i) { // 현재역에서 승차할 수 있는 사람이 예약정보에 있을 때까지 반복
                nums.add(bookings[idx][1]); // 태우기(어린이의 하차역을 요소로 넣기)
                idx++; // 인덱스 증가(다음 예약한 어린이 탐색 위해)
            }
            Collections.sort(nums); // 도착역을 기준으로 오름차순 정렬(수용 인원이 넘어갔을 때 도착역이 먼 애들부터 내리게 하려고)

            // 그리디 핵심 코드
            while(nums.size() > sum[i]) { // 수용인원보다 현재 타고 있는 인원이 많을 때 까지 반복
                nums.pollLast(); // 도착역이 가까운 어린이부터 기차에 태우기 위해 도착역이 먼 승객들 빼내기
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(MaxPeople.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 5}, {2, 4}, {2, 5}, {2, 3}, {3, 5}, {3, 4}}));
    }
}
