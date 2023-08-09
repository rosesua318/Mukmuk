package brute_force.recursion;

import java.util.*;

public class Q14888 {
    static class Pair {
        public int min, max;
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    static Pair calc(int a[], int index, int cur, int plus, int minus, int mul, int div) {
        int n = a.length;
        if(index == n) {
            return new Pair(cur, cur);
        }
        ArrayList<Pair> res = new ArrayList<>();
        if(plus > 0) {
            res.add(calc(a, index + 1, cur + a[index], plus - 1, minus, mul, div));
        }
        if(minus > 0) {
            res.add(calc(a, index + 1, cur - a[index], plus, minus - 1, mul, div));
        }
        if(mul > 0) {
            res.add(calc(a, index + 1, cur * a[index], plus, minus, mul - 1, div));
        }
        if(div > 0) {
            res.add(calc(a, index + 1, cur / a[index], plus, minus, mul, div - 1));
        }
        Pair answer = res.get(0);
        for(Pair p : res) {
            answer.max = Math.max(answer.max, p.max);
            answer.min = Math.min(answer.min, p.min);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();
        Pair answer = calc(a, 1, a[0], plus, minus, mul, div);
        System.out.println(answer.max);
        System.out.println(answer.min);
    }
}