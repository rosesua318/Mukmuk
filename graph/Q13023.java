package graph;

import java.util.*;

public class Q13023 {
    static class Edge {
        int from, to;
        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean a[][] = new boolean[n][n]; // 인접 행렬
        ArrayList<Integer> g[] = (ArrayList<Integer>[]) new ArrayList[n]; // 인접 리스트
        ArrayList<Edge> edges = new ArrayList<Edge>(); // 간선 리스트
        for(int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>(); // 정점 개수만큼 생성
        }
        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
            a[from][to] = a[to][from] = true;
            g[from].add(to);
            g[to].add(from);
        }

        m *= 2;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;
                if(A == B || A == C || A == D || B == C || B == D || C == D) { // A->B, C->D 확인
                    continue;
                }

                if(!a[B][C]) { // B->C 확인
                    continue;
                }
                for(int E : g[D]) { // D->E 확인
                    if(A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}