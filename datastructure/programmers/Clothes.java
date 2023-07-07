package datastructure.programmers;

import java.util.*;

public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1); // 의상 종류별로 구분
        }

        for(String key : map.keySet()) {
            answer *= map.get(key) + 1; // 의상 종류별 의상 수를 곱함. 입지 않는 경우를 고려하기 위해 +1
        }

        return answer - 1; // 어떤 종류도 입지 않은 경우가 1가지 있기 때문에 -1 해줌
    }

    public static void main(String[] args) {
        String[][] clothes = { {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"} };
        Clothes c = new Clothes();
        System.out.println(c.solution(clothes));
    }
}