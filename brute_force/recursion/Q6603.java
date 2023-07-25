package brute_force.recursion;

import java.util.*;

public class Q6603 {
    static ArrayList<Integer> lotto = new ArrayList<>();
    static void solve(int a[], int index, int count) {
        if(count == 6) {
            for(int num : lotto) {
                System.out.print(num + " "); // 조합 출력
            }
            System.out.println();
            return;
        }
        int n = a.length;
        if(n == index) { // 불가능한 경우
            return;
        }

        // 선택하는 경우
        lotto.add(a[index]);
        solve(a, index + 1, count + 1);
        // 선택하지 않는 경우
        lotto.remove(lotto.size() - 1);
        solve(a, index + 1, count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }
            int a[] = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            solve(a, 0, 0); // 재귀 함수 호출
            System.out.println();
        }
    }
}