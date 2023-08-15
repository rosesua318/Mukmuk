package priority_queue.inflearn;

import java.util.*;

public class LectureSchedule {
    static class Lecture implements Comparable<Lecture> {
        public int money;
        public int time;
        Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time; // 날짜를 기준으로 내림차순 정렬
        }
    }

    static int n, max = Integer.MIN_VALUE;
    public static int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 강연료가 높은 순으로 정렬되게
        Collections.sort(arr); // 날짜 내림차순 정렬
        int j = 0;
        for(int i = max; i >= 1; i--) { // 입력 박은 가장 큰 날짜부터 하루씩 작아져서 1일까지 반복
            for( ; j < n; j++) {
                if(arr.get(j).time < i) { // 현재 탐색 날짜보다 마감기한이 짧은 강연인 경우
                    break; // 멈추기
                }
                pq.offer(arr.get(j).money); // 현재 탐색 날짜와 마감기한이 같은 강연이면 우선순위 큐에 넣어주기
            }
            if(!pq.isEmpty()) {
                answer += pq.poll(); // 현재 탐색 날짜에 할 강연을 우선순위 큐에서 뽑아서 강연료 더해주기
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) {
                max = d; // 가장 큰 날짜 구해주기
            }
        }
        System.out.println(LectureSchedule.solution(arr));
    }
}
