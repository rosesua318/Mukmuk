package sort;

import java.io.*;
import java.util.*;

public class Q10814 {
    static class Person implements Comparable<Person> {
        int age;
        String name;
        int join;
        Person(int age, String name, int join) {
            this.age = age;
            this.name = name;
            this.join = join;
        }
        public int compareTo(Person that) {
            if(this.age < that.age) {
                return -1;
            } else if(this.age == that.age) {
                if(this.join < that.join) {
                    return -1;
                } else if(this.join == join) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person a[] = new Person[n];
        for(int i = 0; i < n; i++) {
            String line[] = br.readLine().split(" ");
            a[i] = new Person(Integer.parseInt(line[0]), line[1], i);
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(a[i].age + " " + a[i].name + "\n");
        }
        System.out.print(sb);
    }
}