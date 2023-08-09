package divide_and_conquer;

import java.io.*;
import java.util.*;

public class Q10815 {
    public static boolean binary_search(int[] a, int num) {
        int n = a.length;
        int left = 0;
        int right = n - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(a[mid] == num) {
                return true;
            } else if(a[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line[] = br.readLine().split(" ");
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(a);
        int m = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(line[i]);
            boolean result = binary_search(a, num);
            if(result) {
                answer.append("1 ");
            } else {
                answer.append("0 ");
            }
        }
        System.out.println(answer);
    }
}