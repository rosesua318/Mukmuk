package graph;

import java.util.*;

public class Q16940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n];
        int b[] = new int[n];
        int order[] = new int[n];
        boolean check[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            a[u].add(v);
            a[v].add(u);
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt() - 1;
            order[b[i]] = i; // 각 정점의 탐색 순서 저장
        }
        for(int i = 0; i < n; i++) {
            Collections.sort(a[i], new Comparator<Integer>() { // 탐색 순서를 기준으로 인접 리스트 정렬
                public int compare(Integer u, Integer v) {
                    if(order[u] < order[v]) {
                        return -1;
                    } else if(order[u] == order[v]) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }

        // bfs 탐색하며 순서 bfs_order에 저장
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;
        ArrayList<Integer> bfs_order = new ArrayList<>();
        while(!q.isEmpty()) {
            int x = q.poll();
            bfs_order.add(x); // 탐색 순서 저장
            for(int y : a[x]) {
                if(check[y] == false) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }

        boolean ok = true;
        for(int i = 0; i < n; i++) { // 올바른 순서인지 검사
            if(bfs_order.get(i) != b[i]) {
                ok = false;
            }
        }
        if(ok) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}