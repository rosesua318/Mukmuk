package greedy.inflearn;

import java.util.*;

public class Friend {
    static int[] unf; // 각 원소의 집합 번호를 표현

    public static int Find(int v) { // v의 집합 번호를 리턴하는 함수
        if(v == unf[v]) { // 인덱스 번호와 배열 값(집합 번호)가 같은 경우
            return v; // 인덱스 번호 리턴
        }
        else { // 인덱스 번호와 배열 값(집합 번호)가 다른 경우
            return unf[v] = Find(unf[v]); // 해당 인덱스 번호의 집합 번호를 인덱스 번호로 하는 집합 번호 리턴하며 값 업데이트(경로 압축해서 시간복잡도 줄이기 위해)
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a); // a의 집합 번호 찾기
        int fb = Find(b); // b의 집합 번호 찾기
        if(fa != fb) { // 집합 번호가 서로 다른 경우
            unf[fa] = fb; // 같은 집합 번호로 만들기(a의 집합 번호 -> b의 집합 번호)
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            unf[i] = i; // 각 원소의 인덱스 번호로 집합 초기화
        }
        for(int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Union(a, b); // 친구 관계이므로 한 집합으로 만들기
        }
        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa == fb) { // 같은 집합 번호인 경우 (친구인 경우)
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}