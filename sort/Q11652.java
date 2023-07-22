package sort;

import java.io.*;
import java.util.*;

public class Q11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long a[] = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(a);
        long answer = a[0];
        int answer_count = 1;
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(a[i] == a[i - 1]) {
                count += 1;
            } else {
                count = 1;
            }
            if(answer_count < count) {
                answer_count = count;
                answer = a[i];
            }
        }
        System.out.println(answer);
    }
}