package datastructure;

import java.io.*;
import java.util.*;

public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.contains("push_front")) {
                deque.addFirst(Integer.parseInt(str.split(" ")[1]));
            } else if(str.contains("push_back")) {
                deque.addLast(Integer.parseInt(str.split(" ")[1]));
            } else if(str.equals("pop_front")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println(-1);
                }
            } else if(str.equals("pop_back")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.pollLast());
                } else {
                    System.out.println(-1);
                }
            } else if(str.equals("size")) {
                System.out.println(deque.size());
            } else if(str.equals("empty")) {
                if(deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(str.equals("front")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.peekFirst());
                } else {
                    System.out.println(-1);
                }
            } else if(str.equals("back")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}