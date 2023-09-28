package brute_force.permutation;

import java.util.*;

public class Q10971 {
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
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int d[] = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = i;
        }

        int answer = Integer.MAX_VALUE;
        do {
            // 시작점이 0인 경우에만 계산하여 시작점을 0으로 고정시킴으로써 1->2->3->4 & 2->3->4->1 이렇게 같은 순열인데도 또 계산하게 못하도록 하기
            if(d[0] != 0) {
                break;
            }

            boolean ok = true; // 해당 경로들 사이에 길이 모두 있는지 여부(하나라도 없다면 false해서 계산 못하게)
            int sum = 0; // 해당 경로에서 비용의 합
            for(int i = 0; i < n - 1; i++) {
                if(a[d[i]][d[i + 1]] == 0) { // i번째 도시에서 i+1번째 도시로 가는 경로가 없는 경우
                    ok = false; // 갈 수 없음을 표시 -> 계산 하지 않게
                } else { // 경로가 있는 경우
                    sum += a[d[i]][d[i + 1]]; // i번째->i+1번째로 갈때 드는 비용을 합해주기
                }
            }
            if(ok && a[d[n - 1]][d[0]] != 0) { // 모든 경로가 있으면서 마지막 도시에서 첫 도시로 순회할 수 있는 경우
                sum += a[d[n - 1]][d[0]]; // 마지막 도시 -> 첫번째 도시 순회하는 비용 합해주기
                answer = Math.min(answer, sum); // 최소값 업데이트
            }
        } while(next_permutation(d)); // 다음 순열이 있을 때 까지 반복

        System.out.println(answer);
    }
}