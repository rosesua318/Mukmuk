package sort.inflearn;

import java.util.Arrays;

public class Judges {
    public static int getAvg(int[] score, int s, int e) { // 평균 구하기
        int sum = 0;
        for(int i = s; i <= e; i++) {
            sum += score[i];
        }
        return (int) Math.floor((sum / (e - s + 1)));
    }
    public static int solution(int[] score, int k) {
        int n = score.length;
        Arrays.sort(score); // 점수 오름차순 정렬
        for(int i = 0; i <= n - k; i++) {
            if(score[i + k - 1] - score[i] <= 10) { // 구간에서 최고점수 최저점수 차가 10점 이하일 때
                return getAvg(score, i, i + k - 1); // 구간의 평균 점수 구하기
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(Judges.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(Judges.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
    }
}
