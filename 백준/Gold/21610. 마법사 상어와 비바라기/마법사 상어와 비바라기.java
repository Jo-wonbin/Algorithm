import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Cloud {
        int x, y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int N, M;
    static int map[][];
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Cloud> clouds = new ArrayList<>();
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 1, 1));
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 2, 1));
        Set<Cloud> set = new HashSet<>();
        for (int z = 0; z < M; z++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int go = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[N][N];
            for (Cloud temp : clouds) {
                int x = (temp.x + ((N + dx[dir]) * go)) % N;
                int y = (temp.y + ((N + dy[dir]) * go)) % N;
                temp.x = x;
                temp.y = y;
                map[x][y]++;
                visited[x][y] = true;
            }
            int[][] copy = copy();
            for (Cloud temp : clouds) {
                map[temp.x][temp.y] += findWater(copy, temp.x, temp.y);
            }
            clouds.clear();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] < 2)
                        continue;
                    if (visited[i][j]) {
                        continue;
                    }
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
            set.clear();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
        br.close();
    }

    static int[][] copy() {
        int copy[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    static int findWater(int copy[][], int x, int y) {
        int cnt = 0;
        for (int i = 1; i < 8; i += 2) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1)
                continue;
            if (copy[nx][ny] > 0)
                cnt++;
        }

        return cnt;
    }
}