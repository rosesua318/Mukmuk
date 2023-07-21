package hasing_timeparsing;

import java.util.*;

public class DocumentTheft {
    static class Info implements Comparable<Info> {
        public String name;
        public int time;
        Info(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Info ob) {
            return this.time - ob.time;
        }
    }
    public static int getTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h * 60 + m;
    }
    public static String[] solution(String[] reports, String times) {
        ArrayList<Info> tmp = new ArrayList<>();
        for(String x : reports) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }
        Collections.sort(tmp);
        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);
        ArrayList<String> res = new ArrayList<>();
        for(Info ob : tmp) {
            if(ob.time >= s && ob.time <= e) {
                res.add(ob.name);
            }
            if(ob.time > e) {
                break;
            }
        }
        String answer[] = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DocumentTheft.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57" }, "08:33 09:45")));
    }
}
