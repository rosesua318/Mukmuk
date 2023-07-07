package graph;

import java.util.*;

public class Q1707 {
    public static boolean dfs(ArrayList<Integer>[] a, int[] group, int x, int c) {
        group[x] = c;
        for(int y : a[x]) {
            if(group[y] == 0) { // 아직 방문하지 않았다면
                if(dfs(a, group, y, 3 - c) == false) { // 이분 그래프가 아닌 경우
                    return false;
                }
            } else if(group[y] == group[x]) { // 이미 방문했었고, 현재 노드와 다음 노드의 그룹 번호가 같은 경우
                return false; // 이분 그래프가 아님
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) {
                a[i] = new ArrayList<Integer>();
            }
            for(int i = 0 ; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u].add(v);
                a[v].add(u);
            }
            int group[] = new int[n + 1];
            boolean flag = true;
            for(int i = 1; i <= n; i++) {
                if(group[i] == 0) {
                    if(dfs(a, group, i, 1) == false) { // 그룹 번호 1번으로
                        flag = false;
                    }
                }
            }

            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}