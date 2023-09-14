package binarysearch.inflearn;

import java.util.Arrays;

public class MusicVideo {
    public static int count(int[] arr, int capacity) { // capacity가 각 dvd의 용량일 때 전부 담으려면 몇장 필요한지 계산하는 함수
        int count = 1; // dvd 장수
        int sum = 0; // dvd에 담아내는 몫의 합
        for(int x : arr) {
            if(sum + x > capacity) { // x를 추가했을 때 용량을 넘어가는 경우
                count++; // dvd 1장 추가
                sum = x; // sum에 x 넣기
            } else { // 용량을 넘지 않는 경우
                sum += x; // sum에 x 추가로 더하기
            }
        }
        return count;
    }
    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); // 곡들의 길이 중 최대값을 lt로
        int rt = Arrays.stream(arr).sum(); // 곡들의 길이의 총합을 rt로
        while(lt <= rt) {
            int mid = (lt + rt) / 2; // dvd한장의 용량으로 가정
            if(count(arr, mid) <= m) { // mid 용량으로 최대 m개의 dvd만 사용하여 담을 수 있는 경우
                answer = mid;
                rt = mid - 1;
            } else { // mid 용량으로는 m개로 담아지지 않아서 불가능한 경우
                lt = mid + 1; // mid 보다 더 큰 용량을 범위로 두기 위해
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(MusicVideo.solution(9, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
