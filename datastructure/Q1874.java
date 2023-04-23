package datastructure;

import java.util.*;

public class Q1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int x : arr) {
            if(x > index) {
                while(x > index) {
                    stack.push(++index);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if(stack.peek() != x) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}
