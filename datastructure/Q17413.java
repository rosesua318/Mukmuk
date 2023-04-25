package datastructure;

import java.util.*;

public class Q17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine() + " ";

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(char c : s.toCharArray()) {
            if(c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append("<");
                flag = true;
            } else if(c == '>') {
                sb.append(">");
                flag = false;
            } else if(flag) {
                sb.append(c);
            } else if(c == ' '){
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.push(c);
            }
        }

        System.out.println(sb);
    }
}
