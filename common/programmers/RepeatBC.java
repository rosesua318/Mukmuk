package common.programmers;

import java.util.Arrays;

public class RepeatBC {
    public static int[] solution(String s) {
        int[] answer = new int[2]; // 이진 변환 개수, 제거된 0의 개수

        while(s.length() > 1) { // s가 1이 될때까지 반복
            answer[0]++; // 이진 변환 횟수 증가
            int count = 0; // 1의 길이(개수)
            for(char c : s.toCharArray()) {
                if(c != '0') { // 1이 있는 경우
                    count++; // 1의 길이 증가
                } else { // 0이 있는 경우
                    answer[1]++; // 제거된 0의 개수 증가
                }
            }
            s = Integer.toBinaryString(count); // 1의 개수를 2진수로 변환
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(RepeatBC.solution("110010101001")));
        System.out.println(Arrays.toString(RepeatBC.solution("01110")));
        System.out.println(Arrays.toString(RepeatBC.solution("1111111")));
    }
}