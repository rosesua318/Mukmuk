package sort;

import java.io.*;
import java.util.*;

public class Q10989 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            count[temp] += 1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= 10000; i++) {
            if(count[i] > 0) {
                for(int j = 0; j < count[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
    }
}