package sort;

import java.io.*;
import java.util.*;

public class Q10825 {
    static class Person implements Comparable<Person> {
        String name;
        int kor, eng, math;
        Person(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        public int compareTo(Person that) {
            if(this.kor > that.kor) { // 내림차순
                return -1;
            } else if(this.kor == that.kor) {
                if(this.eng < that.eng) { // 오름차순
                    return -1;
                }  else if(this.eng == that.eng) {
                    if(this.math > that.math) { // 내림차순
                        return -1;
                    } else if(this.math == that.math) {
                        return this.name.compareTo(that.name); // 사전순
                    }
                }
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person a[] = new Person[n];
        for(int i = 0; i < n; i++) {
            String line[] = br.readLine().split(" ");
            a[i] = new Person(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(a[i].name + "\n");
        }
        System.out.print(sb);
    }
}