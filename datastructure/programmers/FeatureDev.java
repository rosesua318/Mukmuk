package datastructure.programmers;

import java.util.*;

public class FeatureDev {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();

        for(int i = 0; i < progresses.length; i++) {
            // 한 개 기능을 개발하는데 필요한 날짜 계산
            double days = (100 - progresses[i]) / (double) speeds[i];
            int day = (int) Math.ceil(days);

            // 함께 배포할 기능 index 찾기
            int j;
            for(j = i + 1; j < progresses.length; j++) {
                if(progresses[j] + day * speeds[j] < 100) { // 배포 불가능한 경우
                    break;
                }
            }

            // 이번에 배포할 기능의 개수 추가
            answer.add(j - i);
            i = j - 1; // 다음 단계에서 i++ 되기 때문에 여기서 -1 해줌 -> i = j로 초기화 되는 것과 같음
        }

        // ArrayList를 array 형태로 변경하여 반환
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };
        FeatureDev f = new FeatureDev();
        System.out.println(Arrays.toString(f.solution(progresses, speeds)));
    }
}