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

            if (temp + 1 <= 100 && !visited[temp + 1]) {
                visited[temp + 1] = true;
                q.add(new Point(temp + 1, now.depth + 1));
            }
            if (temp + 2 <= 100 && !visited[temp + 2]) {
                visited[temp + 2] = true;
                q.add(new Point(temp + 2, now.depth + 1));
            }
            if (temp + 3 <= 100 && !visited[temp + 3]) {
                visited[temp + 3] = true;
                q.add(new Point(temp + 3, now.depth + 1));
            }
            if (temp + 4 <= 100 && !visited[temp + 4]) {
                visited[temp + 4] = true;
                q.add(new Point(temp + 4, now.depth + 1));
            }
            if (temp + 5 <= 100 && !visited[temp + 5]) {
                visited[temp + 5] = true;
                q.add(new Point(temp + 5, now.depth + 1));
            }
            if (temp + 6 <= 100 && !visited[temp + 6]) {
                visited[temp + 6] = true;
                q.add(new Point(temp + 6, now.depth + 1));
            }
        }
    }

}