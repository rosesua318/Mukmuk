package brute_force.recursion;

import java.util.*;;

public class Q9663 {
    static boolean a[][] = new boolean[15][15];
    static int n;
    static boolean check_col[] = new boolean[15];
    static boolean check_dig[] = new boolean[40];
    static boolean check_dig2[] = new boolean[40];
    static boolean check(int row, int col) {
        // |
        if(check_col[col]) {
            return false;
        }
        // 왼쪽 위 대각선
        if(check_dig[row + col]) {
            return false;
        }
        // /
        if(check_dig2[row - col + n]) {
            return false;
        }
        return true;
    }
    static int calc(int row) {
        if(row == n) { // 퀸을 모두 놓은 경우
            return 1;
        }
        int count = 0;
        for(int col = 0; col < n; col++) {
            if(check(row, col)) { // 놓을 수 있는 경우
                check_dig[row + col] = true;
                check_dig2[row - col + n] = true;
                check_col[col] = true;
                a[row][col] = true; // 퀸을 놓음
                count += calc(row + 1); // 재귀 호출
                check_dig[row + col] = false;
                check_dig2[row - col + n] = false;
                check_col[col] = false;
                a[row][col] = false; // 백트래킹
            }
        }
        return count; // 방법의 수 리턴
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(calc(0));
    }
}