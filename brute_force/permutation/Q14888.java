package brute_force.permutation;

import java.util.*;

public class Q14888 {
    static boolean next_permutation(int a[]) {
        int i = a.length - 1;
        while(i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }
        if(i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while(a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    static int calc(int a[], int b[]) { // 식의 값 계산하는 함수
        int n = a.length;
        int answer = a[0]; // 맨 처음 수는 연산자가 없으므로 정답에 그냥 넣기
        for(int i = 1; i < n; i++) { // 모든 수 탐색
            if(b[i - 1] == 0) { // 연산자가 더하기인 경우
                answer += a[i]; // 해당 수 정답에 더해주기
            } else if(b[i - 1] == 1) { // 연산자가 빼기인 경우
                answer -= a[i]; // 해당 수 정답에서 빼주기
            } else if(b[i - 1] == 2) { // 연산자가 곱하기인 경우
                answer *= a[i]; // 해당 수 정답에 곱해주기
            } else { // 연산자가 나누기인 경우
                answer /= a[i]; // 해당 수 정답에 나눠주기
            }
        }
        return answer; // 계산된 값 리턴하기
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n]; // 입력 받은 수들 저장
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int b[] = new int[n - 1]; // 각각의 연산자를 개수만큼 저장
        int m = 0;
        for(int i = 0; i < 4; i++) {
            int count = sc.nextInt();
            for(int k = 0; k < count; k++) {
                b[m++] = i;
            }
        }
        Arrays.sort(b); // 다음 순열 이용하기 위해 연산자 배열 오름차순 정렬
        ArrayList<Integer> result = new ArrayList<>(); // 각각의 경우에 계산된 결과들 저장하기
        do {
            int temp = calc(a, b); // 해당 순열로 계산한 결과
            result.add(temp); // 결과 배열에 해당 값 넣기
        } while(next_permutation(b)); // 다음 순열 이용해서 전체 순열 탐색
        Collections.sort(result); // 결과 배열 오름차순으로 정렬해주기
        m = result.size();
        System.out.println(result.get(m - 1)); // 결과 배열에서 최대값 출력
        System.out.println(result.get(0)); // 결과 배열에서 최소값 출력
    }
}