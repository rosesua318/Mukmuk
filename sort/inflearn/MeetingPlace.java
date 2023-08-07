package sort.inflearn;

import java.util.ArrayList;

public class MeetingPlace {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) { // 사람이 위치한 경우
                    row.add(i); // 행 위치 저장
                    col.add(j); // 열 위치 저장
                }
            }
        }
        col.sort((a, b) -> a - b); // 열은 오름차순 정렬
        int x = row.get(row.size() / 2); // 행의 중값 위치값 구하기
        int y = col.get(col.size() / 2); // 열의 중간 위치값 구하기
        // (x, y)가 사람들이 만나야할 지점이다.
        for(int p : row) {
            answer += Math.abs(x - p); // 각각의 사람들의 행의 위치와 만나야할 지점의 행의 위치 절댓값 구해서 이동거리에 더해주기
        }
        for(int p : col) {
            answer += Math.abs(y - p); // 각각의 사람들의 열의 위치와 만나야할 지점의 열의 위치 절댓값 구해서 이동거리에 더해주기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(MeetingPlace.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
    }
}
