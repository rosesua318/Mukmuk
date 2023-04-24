package datastructure;

import java.io.*;
import java.util.*;

public class Q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int b = -1;
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.contains("push")) {
                b = Integer.parseInt(str.split(" ")[1]);
                queue.offer(b);
            } else if(str.equals("pop")) {
                if(!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(-1);
                }
            } else if(str.equals("size")) {
                System.out.println(queue.size());
            } else if(str.equals("empty")) {
                if(queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(str.equals("front")) {
                if(!queue.isEmpty()) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println(-1);
                }
            } else if(str.equals("back")) {
                if(!queue.isEmpty()) {
                    System.out.println(b);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
