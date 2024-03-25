import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Homework {
        int point, time;

        Homework(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Stack<Homework> stack = new Stack<>();

        int result = 0;

        for (int z = 0; z < T; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            if (flag == 0) {
                if (!stack.isEmpty()) {
                    Homework now = stack.pop();
                    if (now.time - 1 <= 0) {
                        result += now.point;
                    } else {
                        stack.push(new Homework(now.point, now.time - 1));
                    }
                }
            } else {
                int point = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) - 1;

                if (time <= 0) {
                    result += point;
                } else {
                    stack.push(new Homework(point, time));
                }
            }
        }
        System.out.println(result);
        br.close();
    }

}