package greedy;

import java.util.*;

public class Q11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a); // 필요한 시간이 짧은 순대로
        int sum = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i];
            answer += sum;
        }
        System.out.println(answer);
    }
}