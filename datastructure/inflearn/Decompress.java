package datastructure.inflearn;

import java.util.*;

public class Decompress {
    public static String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        for(Character x : s.toCharArray()) {
            if(x == ')') {
                String tmp = "";
                while(!stack.isEmpty()) {
                    String c = stack.pop();
                    if(c.equals("(")) {
                        String num = "";
                        while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }
                        String res = "";
                        int count = 0;
                        if(num.equals("")) {
                            count = 1;
                        } else {
                            count = Integer.parseInt(num);
                        }
                        for(int i = 0; i < count; i++) {
                            res += tmp;
                        }
                        stack.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            } else {
                stack.push(String.valueOf(x));
            }
        }
        for(String x : stack) {
            answer += x;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Decompress.solution("3(a2(b))ef"));
        System.out.println(Decompress.solution("2(ab3((cd)))"));
        System.out.println(Decompress.solution("2(2(ab)3(2(ac)))"));
    }
}
