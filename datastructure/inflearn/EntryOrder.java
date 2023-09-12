package datastructure.inflearn;

import java.util.*;

public class EntryOrder {
    public static int[] solution(int arrival[], int state[]) {
        Queue<Integer> enter = new LinkedList<>(); // 들어가기 위해 대기하는 사원
        Queue<Integer> exit = new LinkedList<>(); // 나가기 위해 대기하는 사원
        int n = arrival.length, prev = 1; // 앞초에 사원이 나갔는지 들어왔는지 여부 표시(1 : 나감, 0 : 들어옴)
        int answer[] = new int[n];
        for(int t = 0, i = 0, count = 0; ; t++) { // 시간을 기준으로 시뮬, i는 사원 가리키는 인덱스, count는 현관문을 사용한 사원수
            if(enter.isEmpty() && exit.isEmpty() && i < n) { // 대기하는 사람이 없으면서 아직 사원이 남았을 때
                if(t < arrival[i]) { // 다음으로 현관문에 도착할 사원의 도착 시간 보다 현재 시간이 작은 경우
                    t = arrival[i]; // 그 시간으로 건너뛰기
                    prev = 1; // 시간을 건너뛰었기 때문에 나가는 사원 우선으로 하게
                }
            }
            while(i < n && arrival[i] <= t) { // 현재 시간(t)에 현관문을 사용하는 사원들이 있을 때 까지
                if(state[i] == 0) { // 들어오는 사원의 경우
                    enter.offer(i); // enter 큐에 인덱스 삽입
                } else { // 나가는 사원의 경우
                    exit.offer(i); // exit 큐에 인덱스 삽입
                }
                i++; // 사원 인덱스 증가
            }
            if(prev == 1) { // 나가는 사원이 우선인 경우
                if(!exit.isEmpty()) { // 나가는 사원 대기열이 비어있지 않은 경우
                    answer[exit.poll()] = t; // 나가는 사원 인덱스에 사용 시간(t초) 적어주기
                    prev = 1; // 사원이 나갔으므로 prev를 1로 업데이트
                } else { // 나가는 사원이 없는 경우 -> 들어오는 사원 이용 가능
                    answer[enter.poll()] = t; // 들어오는 사원 인덱스에 사용 시간 적어주기
                    prev = 0; // 사원이 들어왔으므로 prev를 0으로 업데이트
                }
            } else if(prev == 0) { // 들어오는 사원이 우선인 경우
                if(!enter.isEmpty()) { // 들어오는 사원 대기열이 비어있지 않은 경우
                    answer[enter.poll()] = t; // 들어오는 사원 인덱스에 사용 시간(t초) 적어주기
                    prev = 0; // 사원이 들어왔으므로 prev를 0으로 업데이트
                } else { // 들어오는 사원이 없는 경우 -> 나가는 사원 이용 가능
                    answer[exit.poll()] = t; // 나가는 사원 인덱스에 사용 시간 적어주기
                    prev = 1; // 사원이 나갔으므로 prev를 1로 업데이트
                }
            }
            count++; // 현관문 이용한 사원 수 증가
            if(count == n) { // 전 사원이 현관문 사용했을 때
                break; // 끝내기
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
