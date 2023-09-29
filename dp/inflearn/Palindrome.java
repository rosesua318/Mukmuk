package dp.inflearn;

import java.util.Scanner;

// 백준 1695번 팰린드롬 만들기
public class Palindrome {
    public static int solution(int n, int[] nums) {
        int dy[][] = new int[n + 1][n + 1]; // 1번인덱스부터 사용. dy[i][j] : i번째 수부터 j번째 수까지의 부분수열을 팰린드롬으로 만들기 위해 끼워넣어야 할 수의 최소 개수
        for(int i = 1; i < n; i++) { // i가 1일때는 길이가 2인 수열 탐색. i가 2일때는 길이가 3인 수열 탐색. ,,,. i가 n-1일때는 길이가 n인 수열 탐색
            for(int j = 1; j <= n - i; j++) { // (j, j+i)는 i가 1일때는 (1,2),(2,3),(3,4),(4,5). i가 2일때는 (1,3),(2,4),(3,5) 이런식으로 돎
                if(nums[j] == nums[j + i]) { // 수열의 첫수(j번째)와 마지막수(j+i번째)가 같은 경우
                    dy[j][j + i] = dy[j + 1][j + i - 1]; // 수열의 두번째수와 마지막앞의수로 만든 수열의 dy값이 해당 수열의 dy값이 됨
                } else { // 수열의 첫수와 마지막수가 다른 경우
                    dy[j][j + i] = Math.min(dy[j + 1][j + i], dy[j][j + i - 1]) + 1; // 두번째수와 마지막수로 만든 수열의 dy값과 첫번째수와 마지막앞의수로 만든 수열의 dy값 중 최소값에서 +1을 해준 값이 dy가 됨
                    // +1을 하는 이유는 두번째수와 마지막수로 만든 수열의 dy값을 사용할 때는 첫번째수를 마지막 수 뒤에 추가해야해서 +1해야 하고, 첫번째수와 마지막앞의수로 만든 수열의 dy값을 사용할 때는 마지막수를 첫번째 수 앞에 추가해야 해서 +1해야함
                }
            }
        }
        return dy[1][n]; // 구해야 하는 1번째수부터 n번째수까지로 만든 수열의 dy값 리턴
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 입력 받는 수 개수
        int nums[] = new int[n + 1]; // 1번 인덱스부터 입력 받은 수들 저장
        for(int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Palindrome.solution(n, nums));
    }
}
