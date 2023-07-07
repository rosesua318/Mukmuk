package datastructure;

import java.io.*;
import java.util.*;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second) { // 절댓값이 같은 경우
                return o1 > o2 ? 1 : -1; // 음수 우선 정렬하기
            } else {
                return first - second; // 절댓값을 기준으로 오름차순 정렬
            }
        });

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int req = Integer.parseInt(br.readLine());
            if(req == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(req);
            }
        }
    }
}
