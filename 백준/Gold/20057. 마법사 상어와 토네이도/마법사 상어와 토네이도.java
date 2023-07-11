import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, result, temp, maxTemp;
    static int[][] map;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        temp = 0;
        maxTemp = 1;
        tornado(N / 2 + 1, N / 2 + 1, 0);

        System.out.println(result);

        br.close();
    }

    static void tornado(int x, int y, int dir) {

        while (true) {
            if (x == 1 && y == 1) {
                return;
            }

            result += scatter(x, y, dir);

            temp++;
            boolean flag = true;
            if (temp == maxTemp) {
                flag = false;
                temp = 0;
                if (dir == 1) {
                    maxTemp++;
                } else if (dir == 3) {
                    maxTemp++;
                }
            }
            x += dx[dir];
            y += dy[dir];
            if (!flag)
                dir = (dir + 1) % 4;
        }
    }

    static int scatter(int x, int y, int dir) {
        int out = 0;
        double temp = map[x + dx[dir]][y + dy[dir]];

        double tp1 = Math.floor(temp / 100);
        double tp2 = Math.floor(temp / 50);
        double tp5 = Math.floor(temp / 20);
        double tp7 = Math.floor(temp / 100 * 7);
        double tp10 = Math.floor(temp / 10);

        int a = (int) (temp - 2 * tp1 - 2 * tp2 - tp5 - 2 * tp7 - 2 * tp10);

        if (dir == 0 || dir == 2) {

            if (x - 2 < 1 || y + dy[dir] < 1 || y + dy[dir] > N) {
                out += tp2;
            } else {
                map[x - 2][y + dy[dir]] += tp2;
            }

            if (x + 2 > N || y + dy[dir] < 1 || y + dy[dir] > N) {
                out += tp2;
            } else {
                map[x + 2][y + dy[dir]] += tp2;
            }

            if (x - 1 >= 1) {
                if (y + 2 * dy[dir] >= 1 && y + 2 * dy[dir] <= N) {
                    map[x - 1][y + 2 * dy[dir]] += tp10;
                } else {
                    out += tp10;
                }
                if (y + dy[dir] >= 1 && y + dy[dir] <= N) {
                    map[x - 1][y + dy[dir]] += tp7;
                } else {
                    out += tp7;
                }
                map[x - 1][y] += tp1;
            } else {
                out += tp1 + tp7 + tp10;
            }

            if (x + 1 <= N) {
                if (y + 2 * dy[dir] >= 1 && y + 2 * dy[dir] <= N) {
                    map[x + 1][y + 2 * dy[dir]] += tp10;
                } else {
                    out += tp10;
                }
                if (y + dy[dir] >= 1 && y + dy[dir] <= N) {
                    map[x + 1][y + dy[dir]] += tp7;
                } else {
                    out += tp7;
                }
                map[x + 1][y] += tp1;
            } else {
                out += tp1 + tp7 + tp10;
            }

            if (y + 2 * dy[dir] < 1 || y + 2 * dy[dir] > N) {
                out += a;
            } else {
                map[x][y + 2 * dy[dir]] += a;
            }
            if (y + 3 * dy[dir] < 1 || y + 3 * dy[dir] > N) {
                out += tp5;
            } else {
                map[x][y + 3 * dy[dir]] += tp5;
            }

        } else {

            if (y - 2 < 1 || x + dx[dir] < 1 || x + dx[dir] > N) {
                out += tp2;
            } else {
                map[x + dx[dir]][y - 2] += tp2;
            }
            if (y + 2 > N || x + dx[dir] < 1 || x + dx[dir] > N) {
                out += tp2;
            } else {
                map[x + dx[dir]][y + 2] += tp2;
            }

            if (y - 1 >= 1) {
                if (x + 2 * dx[dir] >= 1 && x + 2 * dx[dir] <= N) {
                    map[x + 2 * dx[dir]][y - 1] += tp10;
                } else {
                    out += tp10;
                }
                if (x + dx[dir] >= 1 && x + dx[dir] <= N) {
                    map[x + dx[dir]][y - 1] += tp7;
                } else {
                    out += tp7;
                }
                map[x][y - 1] += tp1;
            } else {
                out += tp1 + tp7 + tp10;
            }

            if (y + 1 <= N) {
                if (x + 2 * dx[dir] >= 1 && x + 2 * dx[dir] <= N) {
                    map[x + 2 * dx[dir]][y + 1] += tp10;
                } else {
                    out += tp10;
                }
                if (x + dx[dir] >= 1 && x + dx[dir] <= N) {
                    map[x + dx[dir]][y + 1] += tp7;
                } else {
                    out += tp7;
                }
                map[x][y + 1] += tp1;
            } else {
                out += tp1 + tp7 + tp10;
            }

            if (x + 2 * dx[dir] < 1 || x + 2 * dx[dir] > N) {
                out += a;
            } else {
                map[x + 2 * dx[dir]][y] += a;
            }
            if (x + 3 * dx[dir] < 1 || x + 3 * dx[dir] > N) {
                out += tp5;
            } else {
                map[x + 3 * dx[dir]][y] += tp5;
            }

        }
        map[x + dx[dir]][y + dy[dir]] = 0;

        return out;
    }

}