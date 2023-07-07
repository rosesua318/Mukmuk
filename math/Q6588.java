package math;

import java.io.*;
import java.util.*;

public class Q6588 {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean check[] = new boolean[MAX + 1];
        check[0] = check[1] = true;

        ArrayList<Integer> prime = new ArrayList<>();
        for(int i = 2; i * i <= MAX; i++) {
            if(check[i]) {
                continue;
            }
            prime.add(i);
            for(int j = i * 2; j <= MAX; j += i) {
                check[j] = true;
            }
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                return;
            }

            for(int i = 1; i < prime.size(); i++) {
                int p = prime.get(i);
                if(!check[n - p]) {
                    System.out.println(n + " = " + p + " + " + (n - p));
                    break;
                }
            }
        }
    }
}