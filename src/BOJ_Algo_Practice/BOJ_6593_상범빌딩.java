package BOJ_Algo_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {

    static class Point {
        int x, y, z, time;

        public Point(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }

    static int R, C, L;
    static char map[][][];
    static boolean chk[][][];
    static Queue<Point> q = new LinkedList<>();
    static int dx[] = {-1, 1, 0, 0, 0, 0};
    static int dy[] = {0, 0, -1, 1, 0, 0};
    static int dz[] = {0, 0, 0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            map = new char[L][R][C];
            chk = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String temp = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = temp.charAt(k);
                        if (map[i][j][k] == 'S') {
                            q.add(new Point(j, k, i, 0));
                            chk[i][j][k] = true;
                        }
                    }
                }
                String empty = br.readLine();
            }
            bfs();
            q.clear();
        }

        System.out.print(sb);

        br.close();
    }

    private static void bfs() {

        while (!q.isEmpty()) {

            Point now = q.poll();

            if (map[now.z][now.x][now.y] == 'E') {
                sb.append("Escaped in ").append(now.time).append(" minute(s).\n");
                return;
            }

            for (int h = 0; h < 6; h++) {
                int nx = now.x + dx[h];
                int ny = now.y + dy[h];
                int nz = now.z + dz[h];

                if (nx < 0 || ny < 0 || nz < 0 || nx > R - 1 || ny > C - 1 || nz > L - 1)
                    continue;
                if (map[nz][nx][ny] == '#')
                    continue;
                if (chk[nz][nx][ny])
                    continue;

                chk[nz][nx][ny] = true;
                q.add(new Point(nx, ny, nz, now.time + 1));
            }
        }
        sb.append("Trapped!\n");
    }
}
