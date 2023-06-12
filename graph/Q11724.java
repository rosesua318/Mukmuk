package graph;

import java.util.*;

public class Q11724 {
    public static void dfs(ArrayList<Integer>[] a, boolean[] check, int x) {
        if(check[x]) {
            return;
        }
        check[x] = true;
        for(int y : a[x]) {
            if(check[y] == false) {
                dfs(a, check, y);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        boolean check[] = new boolean[n + 1];
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(check[i] == false) {
                dfs(a, check, i);
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
