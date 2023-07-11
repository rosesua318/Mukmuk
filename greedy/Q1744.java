package greedy;

import java.util.*;

public class Q1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        int zero = 0;
        int one = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x == 1) {
                one += 1;
            } else if(x > 0) {
                plus.add(x);
            } else if(x < 0) {
                minus.add(x);
            } else {
                zero += 1;
            }
        }
        Collections.sort(plus);
        Collections.sort(minus); // 오름차순 정렬
        Collections.reverse(plus); // 내림차순 정렬
        if(plus.size() % 2 == 1) { // 양수 짝이 맞지 않는 경우
            plus.add(1); // 1 추가해주기 (변함 없도록)
        }
        if(minus.size() % 2 == 1) { // 음수 짝이 맞지 않는 경우
            minus.add(zero > 0 ? 0 : 1); // 0이 있으면 0 추가, 없으면 1 추가
        }

        int answer = one; // 1의 개수로 초기화
        for(int i = 0; i < plus.size(); i += 2) {
            answer += plus.get(i) * plus.get(i + 1);
        }
        for(int i = 0; i < minus.size(); i += 2) {
            answer += minus.get(i) * minus.get(i + 1);
        }
        System.out.println(answer);
    }
}