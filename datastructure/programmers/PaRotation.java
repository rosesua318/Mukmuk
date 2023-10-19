package datastructure.programmers;

import java.util.*;

public class PaRotation {
    public static int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String str = s.substring(i, s.length()) + s.substring(0, i); // 왼쪽으로 한칸씩 회전시킨 문자열
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(stack.isEmpty()) {
                    stack.push(c);
                } else if(c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if(c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if(c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(PaRotation.solution("[](){}")); // 3
        System.out.println(PaRotation.solution("}]()[{")); // 2
        System.out.println(PaRotation.solution("[)(]")); // 0
        System.out.println(PaRotation.solution("}}}")); // 0
    }
}
