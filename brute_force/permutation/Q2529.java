package brute_force.permutation;

import java.util.*;

public class Q2529 {
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

    static boolean check(int perm[], char a[]) { // 만든 순열이 부등호를 만족하는지 확인하는 함수
        for(int i = 0; i < a.length; i++) { // 부등호를 하나하나 탐색하면서
            if(a[i] == '<' && perm[i] > perm[i + 1]) { // 부등호가 <인데 앞의 수가 더 큰 경우 잘못됐으므로
                return false; // false 리턴
            }
            if(a[i] == '>' && perm[i] < perm[i + 1]) { // 부등호가 >인데 앞의 수가 더 작으면 잘못됐으므로
                return false; // false 리턴
            }
        }
        return true; // 모두 만족하므로 true 리턴
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        char a[] = new char[k]; // 부등호를 담는 배열
        for(int i = 0; i < k; i++) {
            a[i] = sc.next().charAt(0);
        }

        int small[] = new int[k + 1]; // 가장 작은 수를 찾기 위한 배열
        int big[] = new int[k + 1]; // 가장 큰 수를 찾기 위한 배열
        for(int i = 0; i <= k; i++) {
            small[i] = i; // 0부터 k까지의 수를 넣음 (가장 작은 수를 만족하려면 0, 1, 2, ..., k까지 이 수들로만 만들면 되기 때문에)
            big[i] = 9 - i; // 9-k부터 9까지의 수를 넣음 (가장 큰 수를 만족하려면 (9-k), (9-(k-1)), ..., 9까지 이 수들로만 만들면 되기 때문에)
        }

        do { // 최솟값
            if(check(small, a)) { // 하나라도 만족하는 수를 찾게 되면 그게 최솟값이라 더 이상 호출하지 않아도 되기 때문에
                break; // 멈추기
            }
        } while(next_permutation(small)); // 0123부터 다음 순열 다음 순열

        do { // 최댓값
            if(check(big, a)) { // 하나라도 만족하는 수를 찾게 되면 그게 최댓값이라 더 이상 호출하지 않아도 되기 때문에
                break; // 멈추기
            }
        } while(prev_permutation(big)); // 9876부터 이전 순열 이전 순열

        for(int i = 0; i < big.length; i++) {
            System.out.print(big[i]); // 최댓값 출력
        }
        System.out.println();
        for(int i = 0; i < small.length; i++) {
            System.out.print(small[i]); // 최솟값 출력
        }
        System.out.println();
    }
}