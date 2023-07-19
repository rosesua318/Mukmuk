package binarysearch;

import java.util.*;

public class Q2022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double c = sc.nextDouble();
        double left = 0;
        double right = Math.min(x, y);
        while(Math.abs(right - left) > 1e-6) {
            double mid = (left + right) / 2.0;
            double d = mid;
            double h1 = Math.sqrt(x * x - d * d);
            double h2 = Math.sqrt(y * y - d * d);
            double h = (h1 * h2) / (h1 + h2);
            if(h > c) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.printf("%.3f\n", left);
    }
}