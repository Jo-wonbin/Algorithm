import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int map[][], memo[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        memo = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }
        dfs(0, 0);
        System.out.println(memo[0][0]);

        br.close();
    }

    private static int dfs(int x, int y) {

        if (x == N - 1 && y == M - 1) {
            return 1;
        }

        if(memo[x][y] != -1){
            return memo[x][y];
        }

        memo[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
                continue;
            if (map[nx][ny] >= map[x][y])
                continue;
            memo[x][y] += dfs(nx, ny);
        }

        return memo[x][y];
    }
}