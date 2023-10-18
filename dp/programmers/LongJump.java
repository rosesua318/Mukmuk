package dp.programmers;

public class LongJump {
    public static long solution(int n) {
        int[] d = new int[2001]; // d[i] : i칸을 뛸 방법의 수
        d[1] = 1; // 1칸은 방법이 1개
        d[2] = 2; // 2칸은 1,1 or 2로 2개
        for(int i = 3; i < 2001; i++){ // 3부터 2000까지 구하기
            d[i] = (d[i - 2] + d[i - 1]) % 1234567; // 1칸 전에서 오는 경우와 2칸 전에서 오는 경우의 수의 합이 d[i]
        }
        return d[n];
    }
    public static void main(String[] args) {
        System.out.println(LongJump.solution(4));
        System.out.println(LongJump.solution(3));
    }
}
