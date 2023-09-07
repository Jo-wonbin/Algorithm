import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char map[][];
    static int row, col;
    static int dx[] = {-1, 1, 0, 0, 0};
    static int dy[] = {0, 0, -1, 1, 0};
    static boolean ward[][];
    static boolean isVisited[][];
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> points = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        ward = new boolean[row][col];
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();

            for (int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        String way = br.readLine();

        warding(x, y, way);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isVisited[i][j]) {
                    sb.append('.');
                } else
                    sb.append('#');
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int x, int y, char alpa) {
        points.add(new Point(x, y));
        isVisited[x][y] = true;
        while (!points.isEmpty()) {
            Point now = points.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= row || ny >= col)
                    continue;
                if (isVisited[nx][ny])
                    continue;
                if (map[nx][ny] != alpa)
                    continue;

                isVisited[nx][ny] = true;
                points.add(new Point(nx, ny));
            }
        }
    }

    private static void warding(int startX, int startY, String way) {
        q.add(new Point(startX, startY));

        int index = 0;
        while (index < way.length()) {

            Point now = q.poll();

            char dir = way.charAt(index);
            int intDir = 4;
            switch (dir) {
                case 'W':
                    bfs(now.x, now.y, map[now.x][now.y]);
                    break;
                case 'U':
                    intDir = 0;
                    break;
                case 'D':
                    intDir = 1;
                    break;
                case 'L':
                    intDir = 2;
                    break;
                case 'R':
                    intDir = 3;
                    break;

            }
            q.add(new Point(now.x + dx[intDir], now.y + dy[intDir]));

            index++;

        }

        Point lastPoint = q.poll();
        for (int i = 0; i < 5; i++) {
            int nx = lastPoint.x + dx[i];
            int ny = lastPoint.y + dy[i];

            if (nx < 0 || ny < 0 || nx >= row || ny >= col)
                continue;
            isVisited[nx][ny] = true;
        }
    }
}