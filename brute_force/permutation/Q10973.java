package brute_force.permutation;

import java.util.*;

public class Q10973 {
    public static boolean prev_permutation(int a[]) {
        int i = a.length - 1;

        // 1단계 : a[i - 1] > a[i]를 만족하는 가장 큰 i 찾기 (이렇게 되면 0~i-1로 시작하는 첫 순열 상태다.)
        // <예: 7236541일 때 4가 1보다 크므로 i는 6이고 현재 723654로 시작하는 첫 순열>
        while(i > 0 && a[i - 1] <= a[i]) {
            i -= 1;
        }

        if(i <= 0) {
            return false; // 첫 순열이면 false를 리턴해서 다음 순열을 구할 수 없음을 알려줌
        }

        // 2단계 : j ≥ i이면서 a[j] < a[i-1]를 만족하는 가장 큰 j를 찾기
        // (이전 순열을 찾기 위해서는 i번째 이후 수들중에 i-1보다 작은 수면서 j가 가장 큰것을 찾아서 바꿔주기만 하면 바로 이전 순열을 만들 수 있으므로)
        // <예: 7236541일때 i-1인 4보다 작은  수이면서 j가 가장 큰 것은 1이므로 j는 6이다.>
        int j = a.length - 1;
        while(a[j] >= a[i - 1]) {
            j -= 1;
        }

        // 3단계 : a[i-1]과 a[j]를 swap
        // <예 7236541일 때 7246514로 바꿔준다.>
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        // 4단계 : a[i] 이후부터 순열을 뒤집기
        // (i번째부터 뒷부분 수들을 뒤집어주면 0~i-1로 시작하는 마지막 순열이 되기 때문에 바로 이전 순열이 구해진다.)
        // <예: 뒷부분을 내림차순 해주면 724651로 시작하는 마지막 순열이 되기 때문에 723654로 시작하는 첫 순열의 바로 이전 순열을 구한 것이 된다.>
        j = a.length - 1;
        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true; // 이전 순열이 있다는 표시
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if(prev_permutation(a)) { // 이전 순열이 있는 경우
            for(int i = 0; i < n; i++) {
                System.out.print(a[i] + " "); // 이전 순열 출력
            }
            System.out.println();
        } else { // 첫 순열인 경우
            System.out.println("-1"); // -1 출력
        }
    }
}