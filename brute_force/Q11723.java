package brute_force;

import java.io.*;
import java.util.*;

public class Q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 20;
        int m = Integer.parseInt(br.readLine());
        int s = 0;
        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            String line[] = br.readLine().split(" ");
            if(line[0].equals("add")) {
                s = (s | (1 << Integer.parseInt(line[1]) - 1));
            } else if(line[0].equals("remove")) {
                s = (s & ~(1 << Integer.parseInt(line[1]) - 1));
            } else if(line[0].equals("check")) {
                int res = (s & (1 << Integer.parseInt(line[1]) - 1));
                if(res == 0) {
                    sb.append("0\n");
                } else {
                    sb.append("1\n");
                }
            } else if(line[0].equals("toggle")) {
                s = (s ^ (1 << Integer.parseInt(line[1]) - 1));
            } else if(line[0].equals("all")) {
                s = (1 << n) - 1;
            } else if(line[0].equals("empty")) {
                s = 0;
            }
        }
        System.out.print(sb);
    }
}