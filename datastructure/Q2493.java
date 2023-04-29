package datastructure;

import java.io.*;
import java.util.*;

public class Q2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek()[1] < arr[i]) {
                    stack.pop();
                } else {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
            }
            if(stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[] { i + 1, arr[i] }); // 0번째는 타워 순번, 1번째는 타워 높이
        }
    }
}