package datastructure.inflearn;

import java.util.*;

public class Dermatology {
    public static int getTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h * 60 + m;
    }
    public static int solution(int laser[], String enter[]) {
        int answer = 0;
        int n = enter.length;
        int inList[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> q = new LinkedList<>(); // 피부과 대기실
        q.offer(inList[0][1]); // 첫번째 손님의 레이저 번호
        int ft = inList[0][0]; // 첫번째 손님 시간
        int pos = 1; // 인덱스
        for(int t = ft; t <= 1200; t++) { // 1200분까지 시뮬
            if(pos < n && t == inList[pos][0]) { // 처리할 고객이 있고, 현재 시간이 다음 고객이 도착한 시간인 경우
                if(q.isEmpty() && t > ft) { // 대기실이 비어있고 현재 고객이 끝나도 다음 고객이 도착하지 않는 경우
                    ft = t; // 끝나는 시간을 다음 고객이 도착한 시간으로 변경(오자마자 할 수 있도록)
                }
                q.offer(inList[pos][1]); // 다음 고객 대기실에 넣어주기
                pos++; // 인덱스 증가
            }
            if(t == ft && !q.isEmpty()) { // 고객이 치료 끝나고 대기실에 손님이 있는 경우
                int index = q.poll(); // 다음 고객 레이저 번호 얻기
                ft += laser[index]; // 끝나는 시간에 레이저 걸리는 시간 더해주기
            }
            answer = Math.max(answer, q.size()); // 대기실 손님의 최댓값 구하기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Dermatology.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
    }
}
