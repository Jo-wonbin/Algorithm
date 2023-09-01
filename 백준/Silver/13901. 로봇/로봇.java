import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int numOfObstacle = Integer.parseInt(br.readLine());

        int map[][] = new int[row][col];

        for (int i = 0; i < numOfObstacle; i++) {
            st = new StringTokenizer(br.readLine());

            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map[x][y] = 1;

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()) - 1);
        }

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        int sx = x;
        int sy = y;

        int cnt = 0;
        while (true) {
            int now = list.get(cnt);
            cnt = (cnt + 1) % list.size();

            while (true) {
                int nx = sx + dx[now];
                int ny = sy + dy[now];

                if (nx < 0 || ny < 0 || nx > row - 1 || ny > col - 1)
                    break;
                if (map[nx][ny] != 0)
                    break;

                map[nx][ny] = map[sx][sy] + 1;
                sx = nx;
                sy = ny;

            }

            int limit = 0;
            for (int i = 0; i < 4; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];

                if (nx < 0 || ny < 0 || nx > row - 1 || ny > col - 1) {
                    limit++;
                    continue;
                }
                if (map[nx][ny] != 0) {
                    limit++;
                }
            }
            if (limit == 4)
                break;

        }

        System.out.println(sx + " " + sy);

        br.close();
    }
}