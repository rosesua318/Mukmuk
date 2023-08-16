package greedy.inflearn;

import java.util.*;

public class BattleGame {
    static class Info implements Comparable<Info> {
        public int index;
        public Character team;
        public int power;
        Info(int index, Character team, int power) {
            this.index = index;
            this.team = team;
            this.power = power;
        }
        @Override
        public int compareTo(Info o) {
            return this.power - o.power; // 공격력에 대하여 오름차순 정렬
        }
    }
    public static int[] solution(String[] students) {
        int n = students.length;
        int answer[] = new int[n];
        ArrayList<Info> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Character a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            list.add(new Info(i, a, b)); // 학생 번호, 팀 번호, 공격력
        }
        Collections.sort(list); // 공격력에 대해서 오름차순 정렬
        HashMap<Character, Integer> tp = new HashMap<>(); // 각 팀별 공격력의 합
        int j = 0; // i를 쫓아오는 인덱스 역할
        int total = 0; // i번째 앞까지의 공격력 합
        for(int i = 1; i < n; i++) {
            for(; j < n; j++) { // i를 쫓아오는 형태 -> O(n)
                if(list.get(j).power < list.get(i).power) { // i번째 학생의 공격력이 더 높을 때(즉, j가 i와 같아지지 않을 때까지)
                    total += list.get(j).power; // i번째 앞까지의 공격력의 합을 나타내는 변수에 j번째 학생의 공격력 더해주기
                    char x = list.get(j).team;
                    tp.put(x, tp.getOrDefault(x, 0) + list.get(j).power); // 해당 학생 팀의 공격력 더해준 값 해싱
                } else { // i번째 학생보다 공격력이 높으면 멈추고 answer에 i번째 학생의 답 구해준뒤 다음 번째 학생으로 넘어가게
                    break;
                }
            }
            answer[list.get(i).index] = total - tp.getOrDefault(list.get(i).team, 0); // i번째 학생이 가질 수 있는 공격력의 합에서 같은 팀인 학생들의 공격력합을 빼준 값을 answer에 넣기
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(BattleGame.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
    }
}
