package dp;

import java.util.*;

public class Q11727 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[] = new int[1001]; // d[i] : 2xi 직사각형을 채우는 방법의 수
        d[0] = 1; // 0도 1로 초기화 해주기
        d[1] = 1; // 2x1 직사각형을 채우는 방법의 수는 1개

        for(int i = 2; i <= n; i++) { // 2부터 n까지
            // 1. 맨 오른쪽에 세로 사각형 1개를 놓는 경우 : 세로 사각형 제외하면 크기가 2x(i-1)이 되고 이는 d[i-1]임.
            // 2. 맨 오른쪽에 가로 사각형 2개를 놓는 경우 : 가로 사각형 2개를 제외하면 크기가 2x(i-2)가 되고 이는 d[i-2]임.
            // 3. 맨 오른쪽에 2x2 사각형 1개를 놓는 경우 : 2x2 사각형 제외하면 크기가 2x(i-2)가 되고 이는 d[i-2]임.
            // -> d[i]는 이 세 가지 방법의 수의 합이므로 d[i] = d[i - 1] + d[i - 2] * 2가 됨.
            d[i] = d[i - 1] + d[i - 2] * 2;
            d[i] %= 10007;
        }
        System.out.println(d[n]); // 2xn 직사각형을 채우는 방법의 수 출력
    }
}