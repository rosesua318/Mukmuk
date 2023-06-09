package tree;

import java.util.*;

public class Q2250 {
    static class Node {
        int left, right;
        public int order, depth;
        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static Node a[] = new Node[10001];
    static int left[] = new int[10001];
    static int right[] = new int[10001];
    static int count[] = new int[10001];
    static int order = 0;
    static void inorder(int node, int depth) {
        if(node == -1) {
            return;
        }
        inorder(a[node].left, depth + 1);
        a[node].order = ++order;
        a[node].depth = depth;
        inorder(a[node].right, depth + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x] = new Node(y, z);
            if(y != -1) {
                count[y] += 1;
            }
            if(z != -1) {
                count[z] += 1;
            }
        }

        int root = 0;
        for(int i = 1; i <= n; i++) {
            if(count[i] == 0) {
                root = i;
            }
        }

        inorder(root , 1);
        int maxdepth = 0;
        for(int i = 1; i <= n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;
            if(left[depth] == 0) {
                left[depth] = order;
            } else {
                left[depth] = Math.min(left[depth], order);
            }
            right[depth] = Math.max(right[depth], order);
            maxdepth = Math.max(maxdepth, depth);
        }

        int answer = 0;
        int ans_level = 0;
        for(int i = 1; i <= maxdepth; i++) {
            if(answer < right[i] - left[i] + 1) {
                answer = right[i] - left[i] + 1;
                ans_level = i;
            }
        }
        System.out.println(ans_level + " " + answer);
    }
}