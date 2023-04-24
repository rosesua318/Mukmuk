package datastructure;

import java.io.*;
import java.util.*;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();
        for(char c : str.toCharArray()) {
            lstack.push(c);
        }

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(s.contains("L")) {
                if(!lstack.isEmpty()) {
                    rstack.push(lstack.pop());
                }
            } else if(s.contains("D")) {
                if(!rstack.isEmpty()) {
                    lstack.push(rstack.pop());
                }
            } else if(s.contains("B")) {
                if(!lstack.isEmpty()) {
                    lstack.pop();
                }
            } else if(s.contains("P")) {
                String ch = s.split(" ")[1];
                lstack.push(ch.charAt(0));
            }
        }

        while(!lstack.isEmpty()) {
            rstack.push(lstack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!rstack.isEmpty()) {
            sb.append(rstack.pop());
        }

        System.out.println(sb);
    }
}