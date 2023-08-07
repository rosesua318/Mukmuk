package two_pointers.inflearn;

import java.util.Scanner;

public class ConsecutiveNumbers {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1; // 연속된 자연수의 합을 구하기 위해 확인해볼 원소는 n / 2 + 1한 값 까지만
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        for(int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n) {
                answer++;
            }
            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ConsecutiveNumbers T = new ConsecutiveNumbers();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
