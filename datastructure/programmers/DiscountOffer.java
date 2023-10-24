package datastructure.programmers;

import java.util.*;

public class DiscountOffer {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0; // 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수
        int days = 10; // 회원 자격 부여 기간

        HashMap<String, Integer> map = new HashMap<>(); // 정현이가 원하는 제품과 수량 저장
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length - days + 1; i++) { // 1~10, 2~11, 3~12 ... 탐색
            HashMap<String, Integer> dMap = new HashMap<>(); // 각 10일 간 할인하는 제품과 수량
            for(int j = 0; j < days; j++) { // 10일 간의 할인 제품 수량 저장
                dMap.put(discount[i + j], dMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean flag = true; // 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜인지 판별
            for(String key : map.keySet()) {
                if(map.get(key) != dMap.get(key)) { // 제품의 수량이 다른 경우
                    flag = false; // 불가능한 회원등록 날짜임을 표시
                    break; // 멈추기
                }
            }

            answer += flag ? 1 : 0; // 가능하면 날짜 누적해주고 불가능하면 0을 더해주기
        }

        return answer; // 정답 리턴
    }
    public static void main(String[] args) {
        System.out.println(DiscountOffer.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1}, new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
                        "pork", "rice", "pot", "banana", "apple", "banana"})); // 3
        System.out.println(DiscountOffer.solution(new String[]{"apple"}, new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"})); // 0
    }
}
