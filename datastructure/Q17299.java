package datastructure;

import java.io.*;
import java.util.*;

public class Q17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int freq[] = new int[1000001];
        int answer[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            freq[arr[i]] += 1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && freq[arr[stack.peek()]] < freq[arr[i]]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}