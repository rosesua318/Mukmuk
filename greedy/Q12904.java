package greedy;

import java.util.*;

public class Q12904 {
    public static String pop_back(String s) {
        return s.substring(0, s.length() - 1); // 마지막 글자 삭제
    }
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString(); // 문자열 뒤집기
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        while(t.length() > s.length()) {
            if(t.charAt(t.length() - 1) == 'A') { // 마지막 글자가 A일 때
                t = pop_back(t); // A 삭제
            } else { // 마지막 글자가 B일 때
                t = pop_back(t); // B 삭제
                t = reverse(t); // 문자열 뒤집기
            }
        }

        if(s.equals(t)) { // t로 s를 만들 수 있는 경우
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}