package datastructure;

import java.util.*;

public class Q11655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for(char c : s.toCharArray()) {
            if(c >= 'A' && c <= 'Z') { // 대문자인 경우
                c += 13;
                if(c > 'Z') { // 13 더했는데 범위 넘어가는 경우
                    c -= 26;
                }
            } else if(c >= 'a' && c <= 'z') { // 소문자인 경우
                c += 13;
                if(c > 'z') {
                    c -= 26;
                }
            }
            System.out.print(c);
        }
    }
}