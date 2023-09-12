package datastructure.inflearn;

import java.util.*;

public class Decompress {
    public static String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>(); // 스택의 자료형이 Char이 아니라 String이다.
        for(Character x : s.toCharArray()) { // s문자열에 대해서 선형탐색
            if(x == ')') { // 닫는 괄호를 만난 경우
                String tmp = "";
                while(!stack.isEmpty()) { // 스택의 문자열 탐색
                    String c = stack.pop(); // 스택에 있는 문자열 1개 꺼내기
                    if(c.equals("(")) { // 여는 괄호인 경우
                        String num = ""; // 스택에 있는 숫자가 뭔지
                        while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) { // 스택에 있는 숫자 모두 꺼내기(알파벳 전까지)
                            num = stack.pop() + num; // 숫자 구성하기
                        }
                        String res = "";
                        int count = 0;
                        if(num.equals("")) { // 숫자가 없는 경우
                            count = 1; // 1번만 반복이므로 count에 1 저장
                        } else { // 숫자가 있는 경우
                            count = Integer.parseInt(num); // count에 숫자 저장
                        }
                        for(int i = 0; i < count; i++) { // 숫자(count)만큼 문자열 반복 시키기
                            res += tmp;
                        }
                        stack.push(res); // 스택에 압축해제한 결과 문자열 다시 넣기
                        break; // 다시 탐색 이어서 하도록 break
                    }
                    tmp = c + tmp; // 여는 괄호가 아닌 경우(알파벳) 계속 문자열 제일 앞에 더해줌
                }
            } else { // 닫는 괄호가 아닌 경우
                stack.push(String.valueOf(x)); // 스택에 문자열을 넣어주면 된다.
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
