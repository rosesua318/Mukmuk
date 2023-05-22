package brute_force;

import java.util.*;

public class Q3085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char a[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j + 1 < n) { // 오른쪽과 바꾸기
                    char t = a[i][j];
                    a[i][j] = a[i][j + 1];
                    a[i][j + 1] = t;
                    int r = check(a);
                    answer = Math.max(answer, r);
                    t = a[i][j];
                    a[i][j] = a[i][j + 1];
                    a[i][j + 1] = t;
                }
                if(i + 1 < n) { // 아래쪽과 바꾸기
                    char t = a[i][j];
                    a[i][j] = a[i + 1][j];
                    a[i + 1][j] = t;
                    int r = check(a);
                    answer = Math.max(answer, r);
                    t = a[i][j];
                    a[i][j] = a[i + 1][j];
                    a[i + 1][j] = t;
                }
            }
        }
        System.out.println(answer);
    }

    static int check(char a[][]) {
        int n = a.length;
        int answer = 1;
        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 1; j < n; j++) { // 행 계산
                if(a[i][j] == a[i][j - 1]) {
                    count += 1;
                } else {
                    count = 1;
                }
                answer = Math.max(answer, count);
            }

            count = 1;
            for(int j = 1; j < n; j++) { // 열 계산
                if(a[j][i] == a[j - 1][i]) {
                    count += 1;
                } else {
                    count = 1;
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}