import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            boolean flag = q.size() < K ? false : true;

            int first = q.poll();
            if (flag) {
                for (int i = 0; i < K - 1; i++) {
                    q.poll();
                }
                q.add(first);
            } else {
                while (!q.isEmpty()) {
                    q.poll();
                }
                q.add(first);
            }
        }

        System.out.println(q.poll());

        br.close();
    }
}