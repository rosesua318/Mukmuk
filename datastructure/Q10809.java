package datastructure;

import java.util.*;

public class Q10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int arr[] = new int[26];
        Arrays.fill(arr, -1);
        for(char c : s.toCharArray()) {
            arr[c - 'a'] = s.indexOf(c);
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
