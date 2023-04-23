package datastructure;

import java.util.*;

public class Q10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            if(str.contains("push")) {
                stack.push(sc.nextInt());
            } else if(str.contains("pop")) {
                if(stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if(str.contains("size")) {
                sb.append(stack.size()).append("\n");
            } else if(str.contains("empty")) {
                if(stack.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if(str.contains("top")) {
                if(stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}