package brute_force;

import java.util.*;

public class Q6603 {
    public static boolean next_permutation(int a[]) {
        int i = a.length - 1;
        while(i > 0 && a[i - 1] >= a[i]) { // 1단계
            i -= 1;
        }

        if(i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while(a[j] <= a[i - 1]) { // 2단계
            j -= 1;
        }

        int temp = a[i - 1]; // 3단계
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while(i < j) { // 4단계
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }
            int a[] = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int d[] = new int[n];
            for(int i = 0; i < n; i++) {
                if(i < n - 6) {
                    d[i] = 0;
                } else {
                    d[i] = 1;
                }
            }
            ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
            do {
                ArrayList<Integer> cur = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    if(d[i] == 1) {
                        cur.add(a[i]);
                    }
                }
                answer.add(cur);
            } while(next_permutation(d));

            Collections.sort(answer, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                    int n = l1.size();
                    int m = l2.size();
                    int i = 0;
                    while(i < n && i < m) {
                        int t1 = l1.get(i);
                        int t2 = l2.get(i);
                        if(t1 < t2) {
                            return -1;
                        } else if(t1 > t2) {
                            return 1;
                        }
                        i += 1;
                    }
                    if(i == n && i != m) {
                        return -1;
                    } else if(i != n && i == m) {
                        return 1;
                    }
                    return 0;
                }
            });

            for(ArrayList<Integer> v : answer) {
                for(int x : v) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}