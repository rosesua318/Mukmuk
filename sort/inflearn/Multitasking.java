package sort.inflearn;

import java.util.Arrays;

public class Multitasking {
    public static int solution(int[] tasks, long k) {
        int st[] = new int[tasks.length + 1]; // tasks와 동일한데 0번째에 0을 넣어야 하기 때문에 길이 +1 해줌
        System.arraycopy(tasks, 0, st, 1, tasks.length); // tasks 내용을 전체를 st의 1번째부터 복사
        Arrays.sort(st); // 작업의 완료 시간을 기준으로 오름차순 정렬
        int rest = tasks.length; // 남은 작업의 개수
        for(int i = 1; i < st.length; i++) { // 가장빨리 끝나는 작업부터 오래 걸리는 작업까지 탐색하기
            long time = ((long) rest * (st[i] - st[i - 1])); // 해당 작업을 끝내는데 필요한 시간(회전 고려) - 남은 작업의 수 * 남은 회전 횟수
            if(k < time) { // 정전 전까지 해당 작업을 끝내지 못하는 경우
                long index = k % rest; // 남아있는 작업들 중 k초 후 시작처리해야 작업이 몇번째인지 구하기(% rest한 까닭은 회전을 복잡하게 구현하지 않고 회전하고 남은 초만 고려하게)
                int count = 0;
                for(int j = 0; j < tasks.length; j++) {
                    if(tasks[j] >= st[i]) { // 현재 작업이 걸리는 시간 보다 큰 작업인 경우 : 정전 후에도 끝나지 않는 경우
                        if(count == index) { // 정전되고 난 후에 처음으로 처리해야 할 작업의 인덱스인 경우
                            return j + 1; // 인덱스에서 1을 더한 값을 리턴해야 작업의 인덱스임
                        }
                        count++; // 카운트 증가
                    }
                }
            } else { // 정전 전까지 해당 작업을 끝내는 경우
                k -= time; // k초에서 time 빼주기 (남은 시간 갱신)
                rest--; // 하나의 작업이 끝났으므로 남은 작업의 개수 1 감소
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(Multitasking.solution(new int[]{1, 2, 3}, 5));
        System.out.println(Multitasking.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(Multitasking.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
