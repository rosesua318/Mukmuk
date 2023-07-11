package greedy;

import java.util.*;

public class Q10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char s[] = sc.nextLine().toCharArray();

        int sum = 0;
        for(int i = 0; i < s.length; i++) {
            sum += s[i] - '0'; // 각 자리 수의 합 구하기
        }

        Arrays.sort(s); // 오름차순 정렬(0이 있다면 제일 첫번째 인덱스에 0이 있을 것이다.)

        if(s[0] == '0' && sum % 3 == 0) { // 30의 배수인 경우
            for(int i = s.length - 1; i >= 0; i--) { // 가장 큰 수이므로 뒤에서부터 출력
                System.out.print(s[i]);
            }
        } else {
            System.out.println(-1);
        }
    }
}