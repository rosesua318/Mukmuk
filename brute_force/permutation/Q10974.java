package brute_force.permutation;

import java.util.*;

public class Q10974 {
    public static boolean next_permutation(int a[]) {
        int i = a.length - 1;

        // 1단계 : a[i - 1] < a[i]를 만족하는 가장 큰 i 찾기 (0~i-1로 시작하는 마지막 순열 상태임)
        // <예: 7236541일 때 6이 3보다 크므로 i는 3이고 현재 723으로 시작하는 마지막 순열>
        while(i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }

        if(i <= 0) {
            return false; // 마지막 순열이면 false를 리턴해서 다음 순열을 구할 수 없음을 알려줌
        }

        // 2단계 : j ≥ i이면서 a[j] > a[i-1]를 만족하는 가장 큰 j를 찾기
        // (다음 순열을 찾기 위해서는 i번째 이후 수들중에 i-1보다 큰 수면서 j가 가장 큰것을 찾아서 바꿔주기만 하면 바로 다음 순열을 만들 수 있으므로)
        // <예: 7236541일때 i-1인 3보다 큰 수이면서 j가 가장 큰 것은 4이므로 j는 5임.>
        int j = a.length - 1;
        while(a[j] <= a[i - 1]) {
            j -= 1;
        }

        // 3단계 : a[i-1]과 a[j]를 swap
        // <예 : 7236541일 때 7246531로 바꿔준다.>
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        // 4단계 : a[i] 이후부터 순열을 뒤집기
        // (i번째부터 뒷부분 수들을 내림차순으로 뒤집어주면 0~i-1로 시작하는 첫 순열이 되기 때문에 바로 다음 순열이 구해짐.)
        // <예: 7246531을 7241356으로 뒷부분을 오름차순 해주면 724로 시작하는 첫 순열이 되기 때문에 723으로 시작하는 마지막 순열의 바로 다음 순열을 구한 것임.>
        j = a.length - 1;
        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }

        return true; // 다음 순열이 있다는 표시
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = i + 1; // 1부터 n까지 수 저장
        }

        do { // 첫순열도 출력할 수 있도록 do-while
            for(int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } while(next_permutation(a)); // 다음 순열이 있을 때 까지 반복
    }
}