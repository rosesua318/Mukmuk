package math;

import java.io.*;
import java.util.*;

public class Q17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
        }

        int d = arr[0];
        for(int i = 0; i < n; i++) {
            if(i == 1) {
                d = gcd(arr[i - 1], arr[i]);
            } else if(i > 1) {
                d = gcd(arr[i], d);
            }
        }

        System.out.println(d);
    }

    static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
