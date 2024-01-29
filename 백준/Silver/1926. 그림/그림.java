import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int countOfDrawing = 0;
        int maxDrawingArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j])
                    continue;
                if (map[i][j] == 1) {
                    countOfDrawing++;
                    maxDrawingArea = Math.max(maxDrawingArea, bfs(i, j));
                }
            }
        }

        System.out.println(countOfDrawing + "\n" + maxDrawingArea);

        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int areaOfDrawing = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int h = 0; h < 4; h++) {
                int nx = now.x + dx[h];
                int ny = now.y + dy[h];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (map[nx][ny] == 0)
                    continue;
                areaOfDrawing++;
                visited[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
        return areaOfDrawing;
    }
}