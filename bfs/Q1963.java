package bfs;

import java.util.*;

public class Q1963 {
    public static int change(int num, int index, int digit) { // index번째 수를 digit으로 바꾸기
        if(index == 0 && digit == 0) {
            return -1;
        }
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(index, (char)(digit + '0')); // 바꾸기
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean prime[] = new boolean[10001];
        for(int i = 2; i <= 10000; i++) { // 에라토스테네스의 체
            if(prime[i] == false) {
                for(int j = i * i; j <= 10000; j+= i) {
                    prime[j] = true;
                }
            }
        }
        for(int i = 0; i <= 10000; i++) {
            prime[i] = !prime[i];
        }

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean c[] = new boolean[10001];
            int d[] = new int[10001];

            Queue<Integer> q = new LinkedList<Integer>();
            d[n] = 0; // 시작점
            c[n] = true;
            q.add(n);

            while(!q.isEmpty()) {
                int now = q.poll();
                for(int i = 0; i < 4; i++) { // 네 자리
                    for(int j = 0; j <= 9; j++) { // 수의 범위 0~9
                        int next = change(now, i, j);
                        if(next != -1) { // 바꿀 수 있는 경우
                            if(prime[next] && c[next] == false) { // 소수면서 방문하지 않은 경우
                                q.add(next);
                                d[next] = d[now] + 1; // 횟수 업데이트
                                c[next] = true;
                            }
                        }
                    }
                }
            }

            System.out.println(d[m]);
        }
    }
}