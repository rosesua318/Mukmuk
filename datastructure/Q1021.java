package datastructure;

import java.util.*;

public class Q1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        int m  = sc.nextInt();
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            int target = dq.indexOf(arr[i]);
            int size = dq.size();
            int half = size % 2 == 0 ? size / 2 - 1 : size / 2;

            if(target <= half) { // 원소의 위치가 중간 위치 보다 앞에 있는 경우
                for(int j = 0; j < target; j++) {
                    dq.offerLast(dq.pollFirst()); // 2번 연산
                    count++;
                }
            } else { // 원소의 위치가 중간 위치 보다 뒤에 있는 경우
                for(int j = 0; j < size - target; j++) {
                    dq.offerFirst(dq.pollLast()); // 3번 연산
                    count++;
                }
            }
            dq.pollFirst(); // 원소 뽑아내기
        }

        System.out.println(count);
    }
}
