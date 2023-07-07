package dp.inflearn;

import java.util.*;

public class Tower {
    static class Brick implements Comparable<Brick> {
        public int s, h, w;
        Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }
        @Override
        public int compareTo(Brick o) {
            return o.s - this.s; // 넓이에 대해 내림차순 정렬
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a, b, c));
        }

        Collections.sort(arr);

        int d[] = new int[n];
        d[0] = arr.get(0).h;
        int answer = d[0];
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr.get(j).w > arr.get(i).w && d[j] > max) {
                    max = d[j];
                }
            }
            d[i] = max + arr.get(i).h;
            answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }
}
