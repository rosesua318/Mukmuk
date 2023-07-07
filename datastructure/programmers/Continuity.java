package datastructure.programmers;

import java.util.*;

public class Continuity {
    public int[] solution(int []arr) {
        int[] answer;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if(stack.peek() != arr[i]) {
                    stack.push(arr[i]);
                }
            }
        }

        answer = new int[stack.size()];
        int index = 0;
        for(int num : stack) {
            answer[index] = num;
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
        Continuity c = new Continuity();
        System.out.println(Arrays.toString(c.solution(arr)));
    }
}