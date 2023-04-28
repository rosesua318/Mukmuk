package datastructure;

import java.util.*;

public class Q1935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        double arr[] = new double[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Double> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                stack.push(arr[c - 'A']);
            } else {
                double a = stack.pop();
                double b = stack.pop();
                if(c == '+') {
                    stack.push(a + b);
                } else if(c == '-') {
                    stack.push(b - a);
                } else if(c == '*') {
                    stack.push(a * b);
                } else if(c == '/') {
                    stack.push(b / a);
                }
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}