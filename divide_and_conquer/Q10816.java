package divide_and_conquer;

import java.io.*;
import java.util.*;

public class Q10816 {
    public static int lower_bound(int[] a, int num) {
        int n = a.length;
        int left = 0;
        int right = n - 1;
        int answer = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(a[mid] == num) {
                answer = mid;
                right = mid - 1; // 하한
            } else if(a[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static int upper_bound(int[] a, int num) {
        int n = a.length;
        int left = 0;
        int right = n - 1;
        int answer = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(a[mid] == num) {
                answer = mid;
                left = mid + 1; // 상한
            } else if(a[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
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
            int left = lower_bound(a, num);
            int right = upper_bound(a, num);
            if(left == -1) {
                answer.append("0 ");
            } else {
                answer.append((right - left + 1) + " ");
            }
        }
        System.out.println(answer);
    }
}