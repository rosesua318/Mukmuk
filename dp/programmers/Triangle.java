package dp.programmers;

public class Triangle {
    static class Solution {
        public int solution(int[][] triangle) {
            int d[][] = new int[triangle.length][triangle.length];
            d[0][0] = triangle[0][0];
            for(int i = 1; i < triangle.length; i++) {
                for(int j = 0; j <= i; j++) {
                    d[i][j] = d[i - 1][j] + triangle[i][j];
                    if(j - 1 >= 0) {
                        d[i][j] = Math.max(d[i][j], d[i - 1][j - 1] + triangle[i][j]);
                    }
                }
            }

            int answer = d[triangle.length - 1][0];
            for(int i = 0; i < triangle.length; i++) {
                answer = Math.max(answer, d[triangle.length - 1][i]);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        int[][] triangle = { {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(t.solution(triangle));
    }
}
