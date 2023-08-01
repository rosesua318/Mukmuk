package datastructure.inflearn;

import java.util.*;

public class MeetingRoom {
    public static int solution(int n, int[][] meetings) {
        int answer = 0;
        int res[] = new int[n];
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[0] ==b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<Integer> rooms = new TreeSet<>(); // 현재 비어있는 방들을 번호 순으로 정렬되게
        for(int i = 0; i < n; i++) {
            rooms.add(i);
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // 시작 시간 순으로 정렬

        for(int[] m : meetings) {
            while(!ends.isEmpty() && ends.peek()[0] <= m[0]) {
                rooms.add(ends.poll()[1]);
            }
            if(!rooms.isEmpty()) {
                int room = rooms.pollFirst();
                res[room]++;
                ends.add(new int[]{m[1], room});
            } else {
                int[] e = ends.poll();
                res[e[1]]++;
                ends.add(new int[]{e[0] + (m[1] - m[0]), e[1]});
            }
        }

        int maxi = 0;
        for(int i = 0; i < n; i++) {
            if(res[i] > maxi) {
                maxi = res[i];
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(MeetingRoom.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(MeetingRoom.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
    }
}
