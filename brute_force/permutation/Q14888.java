package brute_force.permutation;

import java.util.*;

public class Q14888 {
    static boolean next_permutation(int a[]) {
        int i = a.length - 1;
        while(i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }
        if(i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while(a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    static int calc(int a[], int b[]) {
        int n = a.length;
        int answer = a[0];
        for(int i = 1; i < n; i++) {
            if(b[i - 1] == 0) {
                answer += a[i];
            } else if(b[i - 1] == 1) {
                answer -= a[i];
            } else if(b[i - 1] == 2) {
                answer *= a[i];
            } else {
                answer /= a[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int b[] = new int[n - 1];
        int m = 0;
        for(int i = 0; i < 4; i++) {
            int count = sc.nextInt();
            for(int k = 0; k < count; k++) {
                b[m++] = i;
            }
        }
        Arrays.sort(b);
        ArrayList<Integer> result = new ArrayList<>();
        do {
            int temp = calc(a, b);
            result.add(temp);
        } while(next_permutation(b));
        Collections.sort(result);
        m = result.size();
        System.out.println(result.get(m - 1));
        System.out.println(result.get(0));
    }
}