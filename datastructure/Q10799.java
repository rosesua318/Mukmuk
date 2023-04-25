package datastructure;

import java.util.*;

public class Q10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else {
                stack.pop(); // 닫는 괄호와 짝인 여는 괄호 한개를 뽑아내야 한다.
                if(s.charAt(i - 1) == '(') { // 레이저인 경우
                    count += stack.size();
                } else { // 막대기인 경우
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }
}