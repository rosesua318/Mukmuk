package sort.inflearn;

import java.util.Arrays;

public class Multitasking {
    public static int solution(int[] tasks, long k) {
        int st[] = new int[tasks.length + 1]; // 0번째에 0을 넣어야 하기 때문
        System.arraycopy(tasks, 0, st, 1, tasks.length);
        Arrays.sort(st); // 작업의 소요 시간을 기준으로 오름차순 정렬
        int rest = tasks.length; // 남은 작업의 개수
        for(int i = 1; i < st.length; i++) {
            long time = ((long) rest * (st[i] - st[i - 1])); // 해당 작업을 끝내는데 필요한 시간(회전 고려)
            if(k < time) {
                long index = k % rest; // 남아있는 작업들 중 k초 후 시작처리해야 작업이 몇번째인지 (% rest한 까닭은 무의미한 회전을 하지 않도록)
                int count = 0;
                for(int j = 0; j < tasks.length; j++) {
                    if(tasks[j] >= st[i]) { // 이미 끝난 작업은 제외시키기 위함
                        if(count == index) { // 정전되고 난 후에 처음으로 처리해야 할 인덱스
                            return j + 1; // 인덱스에서 1을 더한 값을 리턴해야 함
                        }
                        count++;
                    }
                }
            } else {
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
