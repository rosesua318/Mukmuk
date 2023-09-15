package sort.inflearn;

import java.util.ArrayList;

public class MeetingPlace {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        ArrayList<Integer> row = new ArrayList<>(); // 사람들의 행 위치를 저장하기 위해
        ArrayList<Integer> col = new ArrayList<>(); // 사람들의 열 위치를 저장하기 위해
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) { // 사람이 위치한 경우
                    row.add(i); // 행 위치 저장
                    col.add(j); // 열 위치 저장
                }
            }
        }
        col.sort((a, b) -> a - b); // 열은 j값들이기 때문에 정렬이 안되어 있는 상태이므로 오름차순 정렬
        int x = row.get(row.size() / 2); // 학생들이 있는 행 개수의 절반 지점으로 모일 장소의 행 위치 구하기
        int y = col.get(col.size() / 2); // 학생들이 있는 열 개수의 절반 지점으로 모일 장소의 열 위치 구하기
        // (x, y)가 모일 장소 지점이다.
        for(int p : row) { // 사람들의 행 위치 탐색
            answer += Math.abs(x - p); // 각각의 사람들의 행의 위치와 만나야할 지점의 행의 위치 차이를 절댓값으로 구해서 이동거리에 더해주기
        }
        for(int p : col) { // 사람들의 열 위치 탐색
            answer += Math.abs(y - p); // 각각의 사람들의 열의 위치와 만나야할 지점의 열의 위치 차이를 절댓값으로 구해서 이동거리에 더해주기
        }
        return answer; // 이동 거리 합의 최소값 리턴
    }
    public static void main(String[] args) {
        System.out.println(MeetingPlace.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
    }
}
