package simulation.inflearn;

import java.util.Arrays;

public class ConferenceRoom {
    public static int[] solution(int[] enter, int[] exit) {
        int n = enter.length;
        for(int i = 0; i < n; i++) { // 0번 사람부터 다루기 위해 입실 명부, 퇴실 명부의 인덱스를 1씩 감소
            enter[i]--;
            exit[i]--;
        }
        int enterIdx[] = new int[n]; // 사람이 몇번째로 왔는지 나타냄
        for(int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i; // 몇번째로 입실했는지 표시
        }
        int enterT[] = new int[n]; // 각 사람이 회의실에 입실한 시각을 나타냄
        int exitT[] = new int[n]; // 각 사람이 회의실에 퇴실한 시각을 나타냄
        int count = 0; // 시간의 흐름
        for(int i = 0, j = 0; i < n; i++) { // 시간의 흐름에 대해서 시뮬 / i, j는 처음 한번만 초기화
            while(j < n && j <= enterIdx[exit[i]]) { // i번째 사람이 들어온 것 보다 먼저 온 사람이 있을 때 까지 반복
                enterT[enter[j]] = count++; // 먼저 온 사람 j의 입실 시간 count로 저장
                j++; // 다음 사람 가리킴
            }
            exitT[exit[i]] = count++; // i번째 사람의 퇴실시간 count로 저장
        }
        int answer[] = new int[n];
        for(int i = 0; i < n; i++) { // i라는 사람과 j라는 사람이 만나는지 여부 보기
            for(int j = i + 1; j < n; j++) {
                // i가 나가는 시간이 j가 들어오는 시간 보다 작거나 j가 나가는 시간이 i가 들어오는 시간 보다 작은 경우가 >아닌< 경우 (무조건 만남)
                if(!(exitT[i] < enterT[j] || exitT[j] < enterT[i])) {
                    answer[i]++; // i가 만나는 사람 명수 1 증가
                    answer[j]++; // j가 만나는 사람 명수 1 증가
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ConferenceRoom.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(ConferenceRoom.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
    }
}
