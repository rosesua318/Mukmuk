package hasing_timeparsing;

import java.util.*;

public class AlertMail {
    public static int getTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h * 60 + m;
    }
    public static String[] solution(String[] reports, int time) {
        HashMap<String, Integer> inT = new HashMap<>();
        HashMap<String, Integer> sumT = new HashMap<>();
        for(String x : reports) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            String c = x.split(" ")[2];
            if(c.equals("in")) {
                inT.put(a, getTime(b));
            } else {
                sumT.put(a, sumT.getOrDefault(a, 0) + (getTime(b) - inT.get(a)));
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for(String name : sumT.keySet()) {
            if(sumT.get(name) > time) {
                res.add(name);
            }
        }
        res.sort((a, b) -> a.compareTo(b));

        String answer[] = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(AlertMail.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in",
        "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
    }
}
