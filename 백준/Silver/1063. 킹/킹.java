import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[9][9];
        int x = king.charAt(1) - '0';
        int y = (king.charAt(0) - 'A') + 1;
        map[x][y] = 1;
        int tx = stone.charAt(1) - '0';
        int ty = (stone.charAt(0) - 'A') + 1;
        map[tx][ty] = -1;

        int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

        for (int i = 0; i < n; i++) {

            String move = br.readLine();
            int dir = 0;

            switch (move) {
                case "R":
                    dir = 0;
                    break;
                case "L":
                    dir = 1;
                    break;
                case "B":
                    dir = 2;
                    break;
                case "T":
                    dir = 3;
                    break;
                case "RT":
                    dir = 4;
                    break;
                case "LT":
                    dir = 5;
                    break;
                case "RB":
                    dir = 6;
                    break;
                case "LB":
                    dir = 7;
                    break;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 1 || ny < 1 || nx > 8 || ny > 8) {
                continue;
            }
            if (map[nx][ny] == -1) {
                int sx = nx + dx[dir];
                int sy = ny + dy[dir];
                if (sx < 1 || sy < 1 || sx > 8 || sy > 8)
                    continue;

                map[sx][sy] = -1;
                tx = sx;
                ty = sy;
            }
            map[x][y] = 0;
            map[nx][ny] = 1;
            x = nx;
            y = ny;
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char) (y + 64)).append(x).append("\n").append((char) (ty + 64)).append(tx);

        System.out.println(sb);

        br.close();
    }

}