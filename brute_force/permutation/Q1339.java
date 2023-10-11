package brute_force.permutation;

import java.util.*;

public class Q1339 {
    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    static int[] alpha = new int[256]; // alpha[i] : 아스키 코드로 i의 값을 나타낸 것
    static int calc(String[] a, Character[] letters, int[] d) { // 합 계산하는 함수
        int m = letters.length; // 서로 다른 알파벳 개수
        int sum = 0;
        for(int i = 0; i < m; i++) {
            alpha[letters[i]] = d[i]; // 각 알파벳에 지정한 수 값으로 넣어줌
        }
        for(String s : a) { // 각 단어 탐색
            int now = 0;
            for(char x : s.toCharArray()) { // 단어의 알파벳 탐색
                now = now * 10 + alpha[x]; // 단어 1개의 값 계산
            }
            sum += now; // 단어 1개의 값을 전체 단어의 합에 더해주기
        }
        return sum; // 전체 단어의 합 리턴하기
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n]; // 입력 받은 단어 저장
        HashSet<Character> s = new HashSet<>(); // 단어의 알파벳 저장(중복을 제거해서 저장)
        for (int i=0; i<n; i++) {
            a[i] = sc.next();
            for (char x : a[i].toCharArray()) {
                s.add(x);
            }
        }
        Character[] letters = s.toArray(new Character[s.size()]); // 중복 제거된 알파벳들을 letters 배열에 저장
        int m = letters.length; // 서로 다른 알파벳의 개수
        int[] d = new int[m]; // 큰 숫자 m개를 뽑아서 저장하기 위한 배열
        for (int i = 0; i < m; i++) {
            d[i] = 9 - i; // 9부터 9-m+1까지의 수를 배열에 저장(큰숫자들로만 이루어짐)
        }
        Arrays.sort(d); // 모든 순열을 살펴보기 위해(다음 순열, 다음 순열로 보기 위해) 오름차순 정렬을 한번 해준다.
        int answer = 0; // 최댓값
        do {
            int now = calc(a, letters, d); // 현재 순열로 계산해보기
            if (answer < now) { // 현재 최대값 보다 큰 경우
                answer = now; // 최대값 업데이트
            }
        } while(next_permutation(d)); // 모든 수의 순열을 바꿔가면서 작은수부터 마지막 순열까지 탐색
        System.out.println(answer); // 최대값 출력
    }
}