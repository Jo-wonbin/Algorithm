import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y, times;

        Point(int x, int y, int times) {
            this.x = x;
            this.y = y;
            this.times = times;
        }
    }

    static int chessBoardSize;
    static boolean[][] visited;
    static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int k = 0; k < N; k++) {
            chessBoardSize = Integer.parseInt(br.readLine());
            visited = new boolean[chessBoardSize][chessBoardSize];

            int sx, sy, ex, ey;
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            sb.append(bfs(sx, sy, ex, ey)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static int bfs(int startX, int startY, int endX, int endY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == endX && now.y == endY) {
                return now.times;
            }

            for (int h = 0; h < 8; h++) {
                int nx = now.x + dx[h];
                int ny = now.y + dy[h];

                if (nx < 0 || ny < 0 || nx >= chessBoardSize || ny >= chessBoardSize)
                    continue;
                if (visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                q.add(new Point(nx, ny, now.times + 1));
            }
        }
        return 0;
    }
}