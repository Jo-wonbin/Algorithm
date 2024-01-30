import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char map[][];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());

        char[] ways = br.readLine().toCharArray();

        map = new char[101][101];

        findMiro(50, 50, ways, 1);

        System.out.println(print());

        br.close();
    }

    private static String print() {
        int maxX = 0;
        int maxY = 0;
        int minX = 101;
        int minY = 101;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == '.') {
                    maxX = Math.max(maxX, i);
                    minX = Math.min(minX, i);
                    maxY = Math.max(maxY, j);
                    minY = Math.min(minY, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxX; i >= minX; i--) {
            for (int j = maxY; j >= minY; j--) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static void findMiro(int x, int y, char[] ways, int dir) {

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';
            }
        }
        map[x][y] = '.';
        for (int i = 0; i < ways.length; i++) {
            if (ways[i] == 'F') {
                x += dx[dir];
                y += dy[dir];

                map[x][y] = '.';
            } else
                dir = findDirection(ways[i], dir);
        }

    }

    private static int findDirection(char order, int dir) {
        return order == 'L' ? (dir + 3) % 4 : (dir + 1) % 4;
    }
}