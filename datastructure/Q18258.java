package datastructure;

import java.io.*;
import java.util.*;

public class Q18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int back = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.contains("push")) {
                queue.offer(Integer.parseInt(s.split(" ")[1]));
                back = Integer.parseInt(s.split(" ")[1]);
            } else if(s.equals("pop")) {
                if(!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if(s.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if(s.equals("empty")) {
                if(!queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append("1").append("\n");
                }
            } else if(s.equals("front")) {
                if(!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if(s.equals("back")) {
                if(!queue.isEmpty()) {
                    sb.append(back).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
