package greedy.inflearn;

import java.util.*;

public class BattleGame {
    static class Info implements Comparable<Info> {
        public int index; // 학생의 번호
        public Character team; // 학생의 팀
        public int power; // 학생의 공격력
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
        int n = students.length; // 학생의 명수
        int answer[] = new int[n]; // 각 학생이 얻는 점수 배열
        ArrayList<Info> list = new ArrayList<>(); // 학생 정보 담기
        for(int i = 0; i < n; i++) {
            Character a = students[i].split(" ")[0].charAt(0); // 팀
            int b = Integer.parseInt(students[i].split(" ")[1]); // 공격력
            list.add(new Info(i, a, b)); // (학생 번호, 팀, 공격력)으로 이루어진 학생 정보 담기
        }
        Collections.sort(list); // 공격력에 대해서 오름차순 정렬
        HashMap<Character, Integer> tp = new HashMap<>(); // 각 팀별 공격력의 누적합
        int j = 0; // i를 쫓아오는 인덱스 역할
        int total = 0; // i번째 학생 앞까지의 공격력 누적 합
        for(int i = 1; i < n; i++) { // 1번째 학생부터 탐색
            for(; j < n; j++) { // i를 쫓아오는 형태 -> O(n)
                if(list.get(j).power < list.get(i).power) { // i번째 학생의 공격력이 더 높을 때(즉, j번째 공격력이 i번째 공격력과 같아지지 않을 때까지)
                    total += list.get(j).power; // i번째 학생 앞까지의 공격력 누적 합을 나타내는 변수에 j번째 학생의 공격력 더해주기(잡힌다는 뜻)
                    char x = list.get(j).team; // j번째 학생의 팀명
                    tp.put(x, tp.getOrDefault(x, 0) + list.get(j).power); // j번째 학생의 공격력을 그 팀 누적합에 더해줘서 해싱 저장 시키기
                } else { // i번째 학생보다 j번째 학생 공격력이 같거나 높으면 멈추고 answer에 i번째 학생의 점수 구해준뒤 다음 번째 학생으로 넘어가게 break하기
                    break;
                }
            }
            answer[list.get(i).index] = total - tp.getOrDefault(list.get(i).team, 0); // i번째 학생이 가질 수 있는 점수 합에서 같은 팀인 학생들의 공격력 누적합을 빼준 값이 점수이므로 answer에 넣기
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(BattleGame.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
    }
}
