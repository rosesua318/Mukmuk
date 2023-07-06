package simulation.inflearn;

public class LostPuppy {
    static public int solution(int[][] board) {
        int n = board.length;
        int dx[] = { -1, 0, 1, 0 }; // 12시, 3시, 6시, 9시 방향
        int dy[] = { 0, 1, 0, -1 };
        int x1 =0, y1 = 0, x2 = 0, y2 = 0; // 현수 위치, 강아지 위치
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 2) { // 현수 위치라면
                    x1 = i;
                    y1 = j;
                }
                if(board[i][j] == 3) { // 강아지 위치라면
                    x2 = i;
                    y2 = j;
                }
            }
        }

        int d1 = 0, d2 = 0, count = 0; // 현수 방향, 강아지 방향, 몇분 걸리는지
        while(count < 10000) {
            count++; // 1분 추가
            int nx1 = x1 + dx[d1];
            int ny1 = y1 + dy[d1];
            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];
            boolean flag1 = true, flag2 = true;
            if(nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) { // 범위 밖이거나 나무인 경우
                d1 = (d1 + 1) % 4; // 90도 회전
                flag1 = false; // 현수 이동 못하게(회전 했기 때문)
            }
            if(nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1) { // 범위 밖이거나 나무인 경우
                d2 = (d2 + 1) % 4; // 90도 회전
                flag2 = false; // 강아지 이동 못하게(회전 했기 때문)
            }
            if(flag1 == true) { // 이동 가능한 경우(회전 안함)
                x1 = nx1; // 현수 이동
                y1 = ny1;
            }
            if(flag2 == true) { // 이동 가능한 경우(회전 안함)
                x2 = nx2; // 강아지 이동
                y2 = ny2;
            }
            if(x1 == x2 && y1 == y2) { // 강아지 찾은 경우
                break;
            }
        }
        if(count >= 10000) {
            return 0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(LostPuppy.solution(new int[][] {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}));
    }
}
