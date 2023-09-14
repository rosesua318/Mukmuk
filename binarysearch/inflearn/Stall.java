package binarysearch.inflearn;

import java.util.Arrays;

public class Stall {
    public static int count(int[] arr, int dist) { // dist를 거리로 했을 때 유효한지 판별
        int count = 1; // 배치한 말의 마리수
        int ep = arr[0]; // 처음 말 배치했으므로 배치한 좌표 ep에 저장
        for(int i = 1; i < arr.length; i++) { // 마구간 좌표를 탐색
            if(arr[i] - ep >= dist) { // i번째 마구간 좌표 위치와 최근에 배치한 말과의 거리가 dist 보다 같거나 큰 경우
                count++; // 배치한 말의 마리수 증가
                ep = arr[i]; // 최근에 말을 배치한 좌표 업데이트
            }
        }
        return count;
    }
    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr); // 좌표들의 위치를 오름차순으로 정렬
        int lt = 1; // 말 사이의 최소 거리는 1이므로 lt를 1로 지정
        int rt = arr[n - 1]; // 가장 큰 마구간 좌표를 rt로 지정
        while(lt <= rt) {
            int mid = (lt + rt) / 2; // 말 사이의 거리
            if(count(arr, mid) >= c) { // 사이 거리를 mid로 했을 때 배치할 수 있는 말의 수가 c보다 같거나 커서 유효한 경우
                answer = mid; // 말 사이의 최대 거리 업데이트
                lt = mid + 1; // 범위 커지게 하기 위해
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Stall.solution(5, 3, new int[]{1, 2, 8, 4, 9}));
    }
}
