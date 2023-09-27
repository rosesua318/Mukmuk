package bfs;

import java.util.*;

public class Q13549 {
    public static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈이 위치
        int m = sc.nextInt(); // 동생 위치
        boolean c[] = new boolean[MAX]; // 방문 여부
        int d[] = new int[MAX]; // 걸리는 시간 저장
        c[n] = true;
        d[n] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>(); // 가중치가 0(초), 1(초)이기 때문에 덱을 이용해서 0은 덱의 앞에, 1은 덱의 뒤에 넣어주기
        q.add(n); // 수빈이 위치 넣어주기
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : new int[]{now * 2, now - 1, now + 1}) { // 순간이동, 걷기
                if(next >= 0 && next < MAX) { // 순간이동과 걷기한 지점이 범위 안인 경우
                    if(c[next] == false) { // 아직 해당 지점을 방문하지 않은 경우
                        c[next] = true; // 방문 표시
                        if(next == now * 2) { // 순간이동하는 경우
                            q.addFirst(next); // 덱의 앞에 넣어주기
                            d[next] = d[now]; // 0초 걸리므로 걸리는 시간을 현재 지점과 똑같게
                        } else { // 걷기하는 경우
                            q.addLast(next); // 덱의 뒤에 넣어주기
                            d[next] = d[now] + 1; // 1초 걸리므로 현재 시간에서 1 더해준 값을 저장
                        }
                    }
                }
            }
        }
        System.out.println(d[m]); // m지점에서의 걸리는 시간 출력
    }
}