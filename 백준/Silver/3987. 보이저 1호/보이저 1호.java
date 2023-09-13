import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y, depth, dir;

        Point(int x, int y, int depth, int dir) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y + " " + this.depth + " " + this.dir;
        }
    }

    static int N, M;
    static char map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static Queue<Point> nowPosition = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        int pr = Integer.parseInt(st.nextToken()) - 1;
        int pc = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(checkMaxDepth(pr, pc));

        br.close();
    }

    private static char checkDirection(int dir) {
        switch (dir) {
            case 0:
                return 'U';
            case 1:
                return 'R';
            case 2:
                return 'D';
            case 3:
                return 'L';
        }
        return 0;
    }

    private static String checkMaxDepth(int pr, int pc) {
        StringBuilder sb = new StringBuilder();
        int maxDepth = -2;
        char dir = 'U';
        for (int i = 0; i < 4; i++) {
            nowPosition.clear();
            int nowDepth = sendSignal(pr, pc, i);
            if (nowDepth == -1) {

                sb.append(checkDirection(i)).append("\n").append("Voyager");
                return sb.toString();
            } else if (nowDepth > maxDepth) {
                dir = checkDirection(i);
                maxDepth = nowDepth;
            }

        }
        sb.append(dir).append("\n").append(maxDepth);
        return sb.toString();

    }

    private static int sendSignal(int pr, int pc, int dir) {

        nowPosition.add(new Point(pr, pc, 1, dir));

        while (!nowPosition.isEmpty()) {
            Point now = nowPosition.poll();

            if (now.depth > N * M * 2) {
                return -1;
            }

            int nx = now.x + dx[now.dir];
            int ny = now.y + dy[now.dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                return now.depth;
            }
            if (map[nx][ny] == 'C') {
                return now.depth;
            }
            if (map[nx][ny] == '/') {
                nowPosition.add(new Point(nx, ny, now.depth + 1, now.dir % 2 == 0 ? now.dir + 1 : now.dir - 1));
                continue;
            }
            if (map[nx][ny] == '\\') {
                nowPosition.add(new Point(nx, ny, now.depth + 1, now.dir % 2 == 0 ? (now.dir + 3) % 4 : (now.dir + 1) % 4));
                continue;
            }
            nowPosition.add(new Point(nx, ny, now.depth + 1, now.dir));
        }
        return 0;
    }
}