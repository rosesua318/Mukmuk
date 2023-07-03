package simulation.inflearn;

public class ClimbTheLadder {
    static public char[] solution(int n, int[][] ladder) {
        char answer[] = new char[n];
        for(int i =0 ; i < n; i++) {
            answer[i] = (char)(i + 65);
        }
        for(int line[] : ladder) {
            for(int x : line) {
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(ClimbTheLadder.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}}));
        System.out.println(ClimbTheLadder.solution(7, new int[][]{{1, 3, 5}, {1, 3,6}, {2, 4}}));
        System.out.println(ClimbTheLadder.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}}));
    }
}
