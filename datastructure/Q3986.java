package datastructure;

import java.util.*;

public class Q3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        while(n-- > 0) {
            String s = sc.next();
            if(s.length() % 2 == 1) { // 문자열 길이가 홀수이면 짝이 맞지 않음
                continue;
            }
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(0));
            for(int i = 1; i < s.length(); i++) {
                if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                    stack.pop(); // 짝 제거하기
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if(stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}