package greedy;

import java.util.*;

public class Q1202 {
    static class Jewel implements Comparable<Jewel> {
        public int m, v, w; // 무게, 가격, w가 0: 보석, 1: 가방
        Jewel(int m, int v, int w) {
            this.m = m;
            this.v = v;
            this.w = w;
        }
        public int compareTo(Jewel that) {
            if(this.m < that.m) { // 무게를 기준으로 오름차순
                return -1;
            } else if(this.m == that.m) { // 무게가 같은 경우
                if(this. w < that.w) { // 가격을 기준으로 오름차순
                    return -1;
                } else if(this.w == that.w) { // 가격이 같은 경우
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Jewel a[] = new Jewel[n + k];
        for(int i = 0; i < n; i++) { // 보석 입력
            int m = sc.nextInt();
            int v = sc.nextInt();
            a[i] = new Jewel(m, v, 0);
        }
        for(int i = 0; i < k; i++) { // 가방 입력
            int m = sc.nextInt();
            a[n + i] = new Jewel(m, 0, 1);
        }

        Arrays.sort(a); // 무게 기준 오름차순 정렬

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        long answer = 0;
        for(Jewel p : a) {
            if(p.w == 0) { // 보석인 경우
                q.offer(-p.v); // 최소 힙을 최대 힙처럼 사용하기 위해서 음수로 넣었다가 뺄때 양수로 바꿈
            } else { // 가방인 경우
                if(!q.isEmpty()) { // 후보 보석이 있는 경우
                    answer += (long) -q.poll(); // 가장 가격이 큰 보석 빼기
                }
            }
        }
        System.out.println(answer);
    }
}