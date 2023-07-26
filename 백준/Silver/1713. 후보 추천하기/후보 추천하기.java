import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        int good, number, cnt;

        Student(int good, int number, int cnt) {
            this.good = good;
            this.number = number;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Student o) {
            if (o.good == this.good) {
                return this.cnt - o.cnt;
            }
            return this.good - o.good;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> students = new ArrayList<>();
        int times = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < times; i++) {
            int temp = Integer.parseInt(st.nextToken());

            boolean flag = false;
            int index = 0;
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).number == temp) {
                    index = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                students.get(index).good++;
            } else {
                if (students.size() == N) {
                    Collections.sort(students);
                    students.remove(0);
                }
                students.add(new Student(1, temp, i));
            }

        }
        ArrayList<Integer> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (Student tp : students) {
            result.add(tp.number);
        }
        Collections.sort(result);
        for (int tp : result) {
            sb.append(tp).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

}