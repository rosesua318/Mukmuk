package simulation.inflearn;

public class TakeFruit {
    public static int getMin(int[] fruit) { // 각 학생의 최솟값 구하기
        int min = 100;
        for(int x : fruit) {
            min = Math.min(min, x);
        }
        return min;
    }
    public static Boolean isMinUnique(int[] fruit) { // 최솟값이 유니크한지 구하기
        int count = 0;
        int min = getMin(fruit);
        for(int x : fruit) {
            if(x == min) {
                count++;
            }
        }
        return count == 1;
    }
    public static int getMinIndex(int[] fruit) { // 최솟값을 가진 인덱스 구하기
        int min = getMin(fruit);
        for(int i = 0; i < 3; i++) {
            if(fruit[i] == min) {
                return i; 
            }
        }
        return 0;
    }
    static public int solution(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int ch[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(ch[i] == 1) { // 이미 교환한 사람인 경우
                continue;
            }
            if(isMinUnique(fruit[i]) == false) { // 최솟값이 유일하지 않은 경우
                continue;
            }
            for(int j = i + 1; j < n; j++) {
                if (ch[j] == 1) { // 이미 교환한 사람인 경우
                    continue;
                }
                if (isMinUnique(fruit[j]) == false) {
                    continue;
                }
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) { // 서로 다른 과일이 최솟값인 경우
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) { // 교환하고 난 뒤에도 최솟값 유지되는 경우
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for(int x[] : fruit) {
            answer += getMin(x); // 총합 구하기
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(TakeFruit.solution(new int[][] {{10, 9, 11}, {15, 20, 25}}));
    }
}
