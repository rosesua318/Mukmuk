package datastructure;

import java.util.*;

public class Q1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                sb.append(c);
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                while(!stack.isEmpty()) {
                    if(stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            } else { // 연산자일 경우
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int priority(char c) {
        if(c == '(') {
            return 0;
        }
        if(c == '+' || c == '-') {
            return 1;
        }
        return 2;
    }
}
