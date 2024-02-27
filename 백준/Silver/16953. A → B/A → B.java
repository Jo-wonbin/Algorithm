import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        long num;
        int count;

        Point(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(find(N, M));
        br.close();
    }

    private static int find(long n, long m) {
        Queue<Point> q = new LinkedList<>();
        Set<Long> set = new HashSet<>();
        q.add(new Point(n, 1));
        set.add(n);

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.num == m) {
                return now.count;
            }

            long next = now.num * 2;
            if (next > m) {
                continue;
            }
            if (!set.contains(next)) {
                set.add(next);
                q.add(new Point(next, now.count + 1));
            }
            next = now.num * 10 + 1;
            if (next > m) {
                continue;
            }
            if (!set.contains(next)) {
                set.add(next);
                q.add(new Point(next, now.count + 1));
            }
        }

        return -1;
    }
}