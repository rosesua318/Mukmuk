package datastructure;

import java.util.*;

public class Q10820{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String s = sc.nextLine();
            int sl = 0;
            int cl = 0;
            int dc = 0;
            int bc = 0;
            for(char c : s.toCharArray()) {
                if(Character.isLowerCase(c)) {
                    sl++;
                } else if(Character.isUpperCase(c)) {
                    cl++;
                } else if(Character.isDigit(c)) {
                    dc++;
                } else if(c == ' ') {
                    bc++;
                }
            }
            System.out.println(sl + " " + cl + " " + dc + " " + bc);
        }
    }
}
