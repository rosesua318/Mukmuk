package datastructure;

import java.io.*;
import java.util.*;

public class Q9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < t; i++) {
            String str = br.readLine() + "\n";
            Stack<Character> stack = new Stack<>();
            for(char c : str.toCharArray()) {
                if(c == ' ' || c == '\n') {
                    while(!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(c);
                } else {
                    stack.push(c);
                }
            }
        }
        bw.flush();
    }
}
