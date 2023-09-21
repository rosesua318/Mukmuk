package graph.inflearn;

import java.util.*;

public class TrainingCourse {
    public static String[] solution(String[] subjects, String[] course) {
        int n = subjects.length; // 교육 과목의 개수
        HashMap<String, Integer> node = new HashMap<>(); // key : 교육 과목 이름, value : 인덱스 번호
        for(int i = 0; i < n; i++) {
            node.put(subjects[i], i);
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // 인접리스트 생성
        }
        int indegree[] = new int[n]; // 진입차수 세기 위해 배열 생성
        for(String x : course) { // 그래프 만들면서 진입차수 카운팅하기
            int a = node.get(x.split(" ")[0]); // 해시를 이용하여 과목 이름이 아닌 인덱스 번호를 구하기
            int b = node.get(x.split(" ")[1]);
            graph.get(b).add(a); // b -> a 방향 그래프 생성
            indegree[a]++; // a 노드의 진입차수 1 증가
        }

        // 위상 정렬
        ArrayList<Integer> order = new ArrayList<>(); // 수강 과목 순서 저장
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) { // 진입 차수가 0인 과목들
                queue.offer(i); // 큐에 노드 번호로 넣어주기
            }
        }
        while(!queue.isEmpty()) { // 큐가 빌때까지 반복
            int pre = queue.poll(); // 큐에서 하나 꺼내기
            order.add(pre); // 꺼낸 과목은 수강하므로 order에 넣어주기
            for(int x : graph.get(pre)) { // 그 과목에 의해서 만들어진 진입차수 감소시키기 위해 방향 그래프 탐색
                indegree[x]--; // 해당 과목과 연결된 과목의 진입차수 1 감소
                if(indegree[x] == 0) { // 진입차수가 0인 경우(선수과목 없으므로 수강할 수 있음)
                    queue.offer(x); // 큐에 넣어주기
                }
            }
        }

        String answer[] = new String[n];
        for(int i = 0; i < n; i++) {
            answer[i] = subjects[order.get(i)]; // order 인덱스 번호에 해당하는 과목 이름들 answer에 추가해주기
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(TrainingCourse.solution(new String[]{"english", "math", "physics", "art", "music"},
                new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
    }
}
