package datastructure.programmers;

import java.util.*;

public class PhoneNumber {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };
        PhoneNumber p = new PhoneNumber();
        System.out.println(p.solution(phone_book));
    }
}