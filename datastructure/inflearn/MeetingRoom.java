package datastructure.inflearn;

import java.util.*;

public class MeetingRoom {
    public static int solution(int n, int[][] meetings) {
        int answer = 0;
        int res[] = new int[n]; // 각 회의실이 몇번이나 사용되었는지 나타내는 배열
        PriorityQueue<int[]> ends = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // 끝나는 시간이 빠른 순서대로, 같다면 회의실 번호가 작은 순서대로
        TreeSet<Integer> rooms = new TreeSet<>(); // 현재 비어있는 회의실들을 번호 기준으로 오름차순으로 정렬되게
        for(int i = 0; i < n; i++) {
            rooms.add(i); // 삽입하는 즉시 logN만에 회의실 번호 기준으로 자동 정렬 해줌
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // meetings 회의 시작 시간 순으로 정렬

        for(int[] m : meetings) { // 회의를 선형 탐색
            while(!ends.isEmpty() && ends.peek()[0] <= m[0]) { // 진행 중인 회의가 있으며 진행중인 회의의 끝나는 시간이 처리할 회의 시작 시간 보다 작을 때 까지 반복
                // 현재 처리할 회의 시작 시간 보다 끝나는 시간이 작은 회의 들은 끝났다는 의미이므로 우선순위 큐에서 뽑아내기
                rooms.add(ends.poll()[1]); // 비어있는 회의실 번호로 추가해주기
            }
            if(!rooms.isEmpty()) { // 빈 회의실이 있는 경우
                int room = rooms.pollFirst(); // 회의실 하나 꺼내기
                res[room]++; // 해당 회의실 사용 빈도수 1 증가 시키기
                ends.add(new int[]{m[1], room}); // 현재 처리할 회의 우선순위 큐에 넣어주기
            } else { // 빈 회의실이 없는 경우
                int[] e = ends.poll(); // 큐에서 가장 빨리 끝나는 회의를 꺼내기 (그만큼 기다렸다고 가정)
                res[e[1]]++; // 회의실 사용 빈도수 1 증가 시키기
                ends.add(new int[]{e[0] + (m[1] - m[0]), e[1]}); // 우선순위 큐에 끝나는 시간을 꺼내온 회의의 끝나는 시간에 현재 처리할 회의가 걸리는 시간 만큼 더해줘서 넣어주기
            }
        }

        int maxi = 0;
        for(int i = 0; i < n; i++) { // 가장 많이 사용된 회의실 번호 찾기
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
