import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Grade {
        int x, y;

        Grade(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while (cnt++ < k) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            ArrayList<Grade> grades = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Grade now = new Grade(x, y);
                grades.add(now);

            }

            Collections.sort(grades, (o1, o2) -> o1.x - o2.x);
            int mazino = grades.get(0).y;

            int result = 1;
            for (int i = 1; i < n; i++) {
                Grade now = grades.get(i);
                if (now.y < mazino) {
                    mazino = now.y;
                    result++;
                }
            }

            sb.append(result).append("\n");

        }

        System.out.println(sb);
        br.close();
    }

}