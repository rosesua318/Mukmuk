package datastructure.inflearn;

import java.util.*;

public class EntryOrder {
    public static int[] solution(int arrival[], int state[]) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length, prev = 1; // 앞초에 사원이 나갔는지 들어왔는지 여부 표시
        int answer[] = new int[n];
        for(int t = 0, i = 0, count = 0; ; t++) { // 시간을 기준으로 시뮬
            if(enter.isEmpty() && exit.isEmpty() && i < n) { // 대기하는 사람이 없으면서 아직 사원이 남았을 때
                if(t < arrival[i]) { // 다음 현관문에 도착할 사원의 시간 보다 현재 시간이 작은 경우
                    t = arrival[i]; // 그 시간으로 건너뛰기
                    prev = 1; // 나가는 사원 우선으로 하게
                }
            }
            while(i < n && arrival[i] <= t) { // 현재 시간에 현관문을 사용한 사원들이 있을 때 까지
                if(state[i] == 0) { // 들어오는 경우
                    enter.offer(i);
                } else { // 나가는 경우
                    exit.offer(i);
                }
                i++; // 인덱스 증가
            }
            if(prev == 1) { // 나가는 사원 우선인 경우
                if(!exit.isEmpty()) { // 나가는 사원 대기열이 비어있지 않은 경우
                    answer[exit.poll()] = t; // 사원 인덱스에 사용 시간 적어주기
                    prev = 1;
                } else { // 비어있는 경우
                    answer[enter.poll()] = t; // 들어오는 사원 인덱스에 사용 시간 적어주기
                    prev = 0;
                }
            } else if(prev == 0) { // 들어오는 사원 우선인 경우
                if(!enter.isEmpty()) { // 비어있지 않은 경우
                    answer[enter.poll()] = t;
                    prev = 0;
                } else { // 비어있는 경우
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            count++; // 현관문 이용한 사원 수 증가
            if(count == n) { // 전 사원이 현관문 사용했을 때
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(EntryOrder.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(EntryOrder.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(EntryOrder.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
