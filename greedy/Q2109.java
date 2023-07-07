package greedy;

import java.util.*;

public class Q2109 {
    static class Lecture implements Comparable<Lecture> {
        int p, d;
        Lecture(int p, int d) {
            this.p = p;
            this.d =d;
        }
        public int compareTo(Lecture that) {
            if(this.d < that.d) { // 날짜를 기준으로 내림차순
                return 1;
            } else if(this.d == that.d) { // 날짜가 같은 경우
                if(this.p < that.p) { // 강연료를 기준으로 오름차순
                    return -1;
                } else if(this.p == that.p) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Lecture a[] = new Lecture[n];
        for(int i = 0; i < n; i++) {
            a[i] = new Lecture(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(a); // 날짜기준 내림차순 정렬

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int answer = 0;
        int k = 0;
        for(int i = 10000; i >= 1; i--) {
            while(k < n && a[k].d == i) { // 같은 날짜일 때까지
                q.offer(-a[k].p);
                k += 1;
            }
            if(!q.isEmpty()) {
                answer += -q.poll(); // 가장 큰 강연료 정답에 더하기
            }
        }

        System.out.println(answer);
    }
}