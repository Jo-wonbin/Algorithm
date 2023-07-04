import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, result, map[][];
    static int dx[] = {0, 1, 1};
    static int dy[] = {1, 0, 1};

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

        dfs(1, 2, 0);

        System.out.println(result);

        br.close();
    }

    private static void dfs(int x, int y, int flag) {

        if (x == N && y == N) {
            result++;
            return;
        }

        switch (flag) {
            case 0:
                for (int i = 0; i < 3; i += 2) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 1 || ny < 1 || nx > N || ny > N)
                        continue;
                    if (map[nx][ny] == 1)
                        continue;
                    if (i == 2) {
                        if (map[x + dx[1]][y + dy[1]] == 1 || map[x + dx[0]][y + dy[0]] == 1)
                            continue;
                    }

                    dfs(nx, ny, i);
                }
                break;
            case 1:
                for (int i = 1; i < 3; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 1 || ny < 1 || nx > N || ny > N)
                        continue;
                    if (map[nx][ny] == 1)
                        continue;
                    if (i == 2) {
                        if (map[x + dx[1]][y + dy[1]] == 1 || map[x + dx[0]][y + dy[0]] == 1)
                            continue;
                    }

                    dfs(nx, ny, i);
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 1 || ny < 1 || nx > N || ny > N)
                        continue;
                    if (map[nx][ny] == 1)
                        continue;
                    if (i == 2) {
                        if (map[x + dx[1]][y + dy[1]] == 1 || map[x + dx[0]][y + dy[0]] == 1)
                            continue;
                    }

                    dfs(nx, ny, i);
                }
                break;
        }
    }
}