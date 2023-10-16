package dp;

import java.util.*;

// 백준 1463번 1로 만들기
public class Q1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // 정수 x 입력 받기
        int d[] = new int[x + 1]; // d[i] : i를 1로 만드는 데 필요한 최소 연산 횟수
        d[1] = 0; // 1을 1로 만드는 데 필요한 연산 횟수는 0
        for(int i = 2; i <= x; i++) { // 2부터 x까지 반복
            d[i] = d[i - 1] + 1; // 1을 빼는 연산. i->i-1로 만들기 위해 연산 1번 + i-1->1로 만들기 위해 필요한 연산 d[i-1]
            if(i % 2 == 0) { // 2로 나누어 떨어지는 경우
                d[i] = Math.min(d[i], d[i / 2] + 1); // 2로 나누는 연산. i->i/2로 만들기 위해 연산 1번 + i/2->1로 만들기 위해 필요한 연산 d[i/2]
            }
            if(i % 3 == 0) { // 3으로 나누어 떨어지는 경우
                d[i] = Math.min(d[i], d[i / 3] + 1); // 3으로 나누는 연산. i->i/3로 만들기 위한 연산 1번 + i/3->1로 만들기 위해 필요한 연산 d[i/3]
            }
        }
        System.out.println(d[x]); // x를 1로 만드는 데 필요한 최소 연산 횟수 출력
    }
}