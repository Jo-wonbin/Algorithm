import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static boolean flag = false;
    static char[][] map;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static ArrayList<Point> teacher = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') {
                    teacher.add(new Point(i, j));
                }
            }
        }
        Comb(0, 0);

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }

    static boolean find() {

        for (int i = 0; i < teacher.size(); i++) {
            Point now = teacher.get(i);
            for (int h = 0; h < 4; h++) {
                int nx = now.x + dx[h];
                int ny = now.y + dy[h];

                while (true) {
                    if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1)
                        break;
                    if (map[nx][ny] == 'O')
                        break;
                    if (map[nx][ny] == 'S')
                        return false;

                    nx += dx[h];
                    ny += dy[h];
                }
            }
        }

        return true;
    }

    static void Comb(int cnt, int now) {
        if (cnt == 3) {
            if (find()) {
                flag = true;
            }
            return;
        }

        if (flag)
            return;

        for (int i = now; i < N * N; i++) {
            if (map[i / N][i % N] == 'X') {
                map[i / N][i % N] = 'O';
                Comb(cnt + 1, i + 1);
                map[i / N][i % N] = 'X';
            }
        }
    }
}