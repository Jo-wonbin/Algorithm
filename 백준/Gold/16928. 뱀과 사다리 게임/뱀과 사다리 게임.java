import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x, depth;

        Point(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }

    static Map<Integer, Integer> ladders = new HashMap<>();
    static Map<Integer, Integer> snakes = new HashMap<>();
    static Queue<Point> q = new LinkedList<>();
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        result = 10000;

        find();

        System.out.println(result);

        br.close();
    }

    public static void find() {
        q.add(new Point(1, 0));
        boolean[] visited = new boolean[101];
        visited[1] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == 100) {
                result = Math.min(result, now.depth);
                continue;
            }

            int temp = now.x;
            if (ladders.containsKey(now.x)) {
                temp = ladders.get(now.x);
            }

            if (snakes.containsKey(now.x)) {
                temp = snakes.get(now.x);
            }

            for (int i = 1; i <= 6; i++) {
                if (temp + i > 100)
                    continue;
                if (visited[temp + i])
                    continue;
                visited[temp + i] = true;
                q.add(new Point(temp + i, now.depth + 1));
            }
        }
    }

}