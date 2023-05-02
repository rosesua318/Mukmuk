package datastructure.programmers;

import java.util.*;

public class Scoville {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }

        while(!pq.isEmpty()) {
            int current = pq.poll();
            if(current < K) {
                if(pq.size() == 0) {
                    return -1;
                }
                int next = pq.poll();
                int sum = current + next * 2;
                pq.offer(sum);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;
        Scoville s = new Scoville();
        System.out.println(s.solution(scoville, K));
    }
}
