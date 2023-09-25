package dp.inflearn;

import java.util.Scanner;

// 2073번 수도배관공사
public class Piping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(); // 만들어야 될 수도관의 길이
        int p = sc.nextInt(); // 파이프의 개수
        int dy[] = new int[d + 1]; // 다이나믹 테이블 생성
        for(int i = 0; i < p; i++) { // 파이프들을 탐색
            int l = sc.nextInt(); // 파이프 길이
            int c = sc.nextInt(); // 파이프 용량

            // 다이나믹 적용
            for(int j = d; j > l; j--) { // 만들어야될 수도관의 길이부터 현재 파이프 길이의 바로 전까지만 반복하기 (뒤에서부터 해야 중복 사용 방지 가능)
                if(dy[j - l] == 0) { // 현재 탐색중인 j라는 길이에서 현재 파이프의 길이를 뺐을 때 0인 경우
                    continue; // (j-l)수도관은 만들어있지 않으니까 현재 파이프를 사용해서 값을 구하지 못한다는 말이므로 건너뛰기
                }
                dy[j] = Math.max(dy[j], Math.min(dy[j - l], c)); // (j-l)길이의 수도관 용량과 현재 파이프 용량 중에서의 최소값과 j길이의 수도관 용량 중 최대값을 dy[j]로 업데이트
            }
            // l전까지 돌았으므로 마지막은 l길이의 수도관 용량도 정해주기
            dy[l] = Math.max(dy[l], c); // l길이인 현재 파이프를 사용한 용량과 기존 l길이의 수도관의 용량 중 최대값으로 업데이트 해주기
        }
        System.out.println(dy[d]); // 최종적으로 d길이의 수도관 용량을 출력해주기
    }
}
