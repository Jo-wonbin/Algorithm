import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y, cnt;
        boolean flag;

        Point(int x, int y, int cnt, boolean flag) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.flag = flag;
        }
    }

    static int N, M, result;
    static char map[][];
    static boolean[][] visited, fired;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        fired = new boolean[N][M];

        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                char tp = temp.charAt(j);
                map[i][j] = tp;
                if (tp == 'J') {
                    x = i;
                    y = j;
                }
            }
        }

        q.add(new Point(x, y, 1, true));
        visited[x][y] = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'F') {
                    q.add(new Point(i, j, 0, false));
                    fired[i][j] = true;
                }
            }
        }

        result = Integer.MAX_VALUE;

        if(bfs()) System.out.println(result);
        else System.out.println("IMPOSSIBLE");

        br.close();
    }

    private static boolean bfs() {
        boolean possible = false;
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.flag) {
                if (map[now.x][now.y] == 'F')
                    continue;

                for (int h = 0; h < 4; h++) {
                    int nx = now.x + dx[h];
                    int ny = now.y + dy[h];

                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                        result = Math.min(result, now.cnt);
                        possible = true;
                        continue;
                    }
                    if (visited[nx][ny])
                        continue;
                    if (map[nx][ny] == '#')
                        continue;
                    if (map[nx][ny] == 'F')
                        continue;

                    q.add(new Point(nx, ny, now.cnt + 1, true));
                    visited[nx][ny] = true;
                }
            } else {
                for (int h = 0; h < 4; h++) {
                    int nx = now.x + dx[h];
                    int ny = now.y + dy[h];

                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
                        continue;
                    if (fired[nx][ny])
                        continue;
                    if (map[nx][ny] == '#')
                        continue;
                    if (map[nx][ny] == 'F')
                        continue;

                    map[nx][ny] = 'F';
                    q.add(new Point(nx, ny, 0, false));
                    fired[nx][ny] = true;
                }
            }
        }
        return possible;
    }

}