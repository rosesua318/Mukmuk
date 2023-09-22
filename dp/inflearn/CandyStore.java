package dp.inflearn;

import java.util.Scanner;

// 백준 4781번 사탕 가게
public class CandyStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt(); // 사탕 종류 개수
            int m = (int) Math.round(sc.nextDouble() * 100); // 상근이가 가지고 있는 돈을 100곱한 뒤에 반올림 해줌(부동소수점 오차 때문에)
            if(n == 0 && m == 0) { // 두 입력이 모두 0인 경우 끝내기
                break;
            }
            int dy[] = new int[m + 1]; // dy[i] : 상근이가 i원을 가지고 얻을 수 있는 최대 칼로리
            for(int i = 0; i < n; i++) {
                int c = sc.nextInt(); // 사탕 칼로리
                int p = (int) Math.round(sc.nextDouble() * 100); // 사탕 가격을 100 곱한 뒤에 반올림 해줌(부동소수점 오차 때문에)
                for(int j = p; j <= m; j++) { // 사탕 가격과 같거나 큰 모든 dy 테이블 인덱스들 업데이트 해줌
                    dy[j] = Math.max(dy[j], dy[j - p] + c); // dy[j]에 저장되어 있는 최대 칼로리 보다 j에서 사탕 가격을 뺀 인덱스에 해당하는 칼로리에 사탕 칼로리를 더해준 값이 더 큰 경우 업데이트
                }
            }
            System.out.println(dy[m]); // 가지고 있는 돈으로 얻을 수 있는 최대 칼로리 출력
        }
    }
}
