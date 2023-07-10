package greedy;

import java.util.*;

public class Q1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> sign = new ArrayList<>();
        boolean minus = false;
        int cur = 0;
        sign.add(1); // 가장 앞의 숫자는 +로 생각
        for(char x : s.toCharArray()) {
            if(x == '+' || x == '-') { // 연산자인 경우
                if(x == '+') { // 더하기인 경우
                    sign.add(1);
                } else { // 빼기인 경우
                    sign.add(-1);
                }
                num.add(cur);
                cur = 0;
            } else {
                cur = cur * 10 + (x - '0');
            }
        }
        num.add(cur);

        int answer = 0;
        minus = false;
        for(int i = 0; i < num.size(); i++) {
            if(sign.get(i) == -1) {
                minus = true;
            }
            if(minus) {
                answer -= num.get(i);
            } else {
                answer += num.get(i);
            }
        }
        System.out.println(answer);
    }
}