package datastructure;

import java.util.*;

public class Q5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            String p = sc.next();
            int n = sc.nextInt();
            StringTokenizer st = new StringTokenizer(sc.next(), "[],");
            LinkedList<Integer> dq = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            boolean isRight = true;
            boolean isError = false;
            for(char c : p.toCharArray()) {
                if(c == 'R') {
                    isRight = !isRight;
                    continue;
                }

                if(isRight) {
                    if(dq.pollFirst() == null) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                } else {
                    if(dq.pollLast() == null) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                }
            }

            if(!isError) {
                sb.append("[");
                if(dq.size() > 0) {

                    if(isRight) { // 정방향일 경우
                        sb.append(dq.pollFirst());
                        while (!dq.isEmpty()) {
                            sb.append(",").append(dq.pollFirst());
                        }
                    } else {
                        sb.append(dq.pollLast());
                        while (!dq.isEmpty()) {
                            sb.append(",").append(dq.pollLast());
                        }
                    }

                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}