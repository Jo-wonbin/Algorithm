import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int dx[] = {0, -1, 0, 1};
        int dy[] = {-1, 0, 1, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') {
                    int underTheSea = 0;
                    for (int h = 0; h < 4; h++) {
                        int nx = i + dx[h];
                        int ny = j + dy[h];

                        if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1 || map[nx][ny] == '.')
                            underTheSea++;
                    }
                    if (underTheSea >= 3) {
                        visited[i][j] = true;
                    }
                }
            }
        }

        int maxX = -1;
        int maxY = -1;
        int minX = N;
        int minY = M;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    map[i][j] = '.';
                }
                if (!visited[i][j] && map[i][j] == 'X') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}