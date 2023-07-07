package datastructure;

import java.util.*;

public class Q9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(char c : str.toCharArray()) {
                if(c == '(') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) {
                flag = false;
            }
            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
