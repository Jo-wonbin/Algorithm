import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        // 각각 후보의 추천수, 숫자, 등록 시간
        int good, number, cnt;

        Student(int good, int number, int cnt) {
            this.good = good;
            this.number = number;
            this.cnt = cnt;
        }

        // 추천 수 기준 오름차순 정렬, 추천 수가 같으면 등록 시간이 오래된 것이 우선
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

            // 후보의 숫자
            int numberOfStudent = Integer.parseInt(st.nextToken());

            // 사진틀에 있는 후보 판별 변수
            boolean flag = false;

            // 해당 후보의 인덱스
            int index = 0;

            // 사진틀에 후보가 있는지 판단하여 해당 인덱스를 반환
            for (int j = 0; j < students.size(); j++) {
                if (students.get(j).number == numberOfStudent) {
                    index = j;
                    flag = true;
                    break;
                }
            }

            // 사진틀에 후보가 있으면 해당 후보의 추천수 증가
            if (flag) {
                students.get(index).good++;
            }
            // 후보가 없다면
            else {
                // 사진틀이 꽉찼으면 정렬하여 추천수가 가장 적고 등록된지 가장 오래된 후보 삭제
                if (students.size() == N) {
                    Collections.sort(students);
                    students.remove(0);
                }
                // 사진틀에 후보 넣기
                students.add(new Student(1, numberOfStudent, i));
            }

        }

        // 사진틀에 등록된 후보의 숫자를 오름차순으로 정렬하여 출력할 리스트
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