import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x, y, depth, num;

        public Point(int x, int y, int depth, int num) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.num = num;
        }
    }

    static int N, M, result;
    static int length[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static char map[][];
    static boolean visited[];
    static Queue<Point> q = new LinkedList<>();
    static ArrayList<Point> dirt = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Loop1:
        while (true) {
            dirt.clear();
            q.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 || M == 0)
                break;

            map = new char[M][N];

            int x = 0, y = 0;
            int num = 1;
            for (int i = 0; i < M; i++) {
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    char tp = temp.charAt(j);
                    map[i][j] = tp;
                    if (tp == '*')
                        dirt.add(new Point(i, j, 0, num++));
                    if (tp == 'o') {
                        x = i;
                        y = j;
                    }
                }
            }
            dirt.add(0, new Point(x, y, 0, 0));
            length = new int[dirt.size()][dirt.size()];

            result = Integer.MAX_VALUE;
            for (int i = 0; i < dirt.size(); i++) {
                q.clear();
                if (bfs(i) != 0) {
                    sb.append(-1).append("\n");
                    continue Loop1;
                }
            }

            visited = new boolean[dirt.size()];

            dfs(0, 0, 0);

            sb.append(result).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

        br.close();
    }

    static int bfs(int index) {
        int cnt = dirt.size();
        Point temp = dirt.get(index);
        q.add(new Point(temp.x, temp.y, 0, temp.num));
        boolean check[][] = new boolean[M][N];

        check[temp.x][temp.y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (map[now.x][now.y] == '*' || map[now.x][now.y] == 'o') {
                cnt -= 1;

                for (int i = 0; i < dirt.size(); i++) {
                    if (i == index)
                        continue;
                    Point tp = dirt.get(i);
                    if (now.x == tp.x && now.y == tp.y) {
                        length[temp.num][tp.num] = now.depth;
                    }
                }
            }

            for (int h = 0; h < 4; h++) {

                int nx = now.x + dx[h];
                int ny = now.y + dy[h];

                if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1)
                    continue;
                if (check[nx][ny])
                    continue;
                if (map[nx][ny] == 'x')
                    continue;
                check[nx][ny] = true;
                q.add(new Point(nx, ny, now.depth + 1, now.num));
            }
        }
        return cnt;
    }

    static void dfs(int cnt, int now, int idx) {
        if (cnt == dirt.size() - 1) {

            result = Math.min(now, result);
            return;
        }

        for (int i = 1; i < dirt.size(); i++) {

            if (visited[i])
                continue;
            visited[i] = true;
            dfs(cnt + 1, now + length[idx][i], i);
            visited[i] = false;
        }

    }

}