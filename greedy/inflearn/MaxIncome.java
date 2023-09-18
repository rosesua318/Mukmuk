package greedy.inflearn;

import java.util.*;

public class MaxIncome {
    static class Lecture implements Comparable<Lecture> {
        public int money;
        public int time;
        Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }
        @Override
        public int compareTo(Lecture ob) {
            return ob.time - this.time; // 강연 날짜를 기준으로 내림차순 정렬
        }
    }

    static int n, max = Integer.MIN_VALUE;

    public static int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 강연료가 높은 순서대로 먼저 꺼내줌
        Collections.sort(arr); // 강연 날짜를 기준으로 내림차순 정렬됨
        int j = 0;
        for(int i = max; i >= 1; i--) { // 강연 날짜가 제일 큰 날짜부터 1일까지 하루씩 감소시키며 내림차순으로 탐색
            for( ; j < n; j++) { // 정렬되어 있는 강연들 하나씩 탐색
                if(arr.get(j).time < i) { // j번째 강연 날짜가 탐색하고 있는 날짜 i 보다 작은 경우 -> 멈춰야됨
                    break;
                } else { // j번째 강연 날짜가 탐색하고 있는 날짜 i 보다 크거나 같은 경우
                    pq.offer(arr.get(j).money); // 강연료 우선순위 큐에 삽입
                }
            }
            if(!pq.isEmpty()) { // 비어있지 않으면
                answer += pq.poll(); // 현재 탐색하고 있는 날짜 i에서 선택하는 가장 최고 강연료인 강연 뽑아서 answer에 더해주기
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) {
                max = d; // 입력 받은 강연 날짜 중 가장 큰값인 날짜 찾기(하나씩 감소시키며 탐색시키기 위해)
            }
        }
        System.out.println(MaxIncome.solution(arr));
    }
}