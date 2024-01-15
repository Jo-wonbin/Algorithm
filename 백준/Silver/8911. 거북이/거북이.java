import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 좌상우하 0123
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int k = 0; k < N; k++) {

            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int x = 0;
            int y = 0;
            int direction = 1;

            int minX, minY, maxX, maxY;
            minX = minY = maxX = maxY = 0;

            for (int i = 0; i < order.length(); i++) {
                char letter = order.charAt(i);
                if (letter == 'F') {
                    x += dx[direction];
                    y += dy[direction];

                    maxX = Math.max(x, maxX);
                    maxY = Math.max(y, maxY);
                    minX = Math.min(x, minX);
                    minY = Math.min(y, minY);

                } else if (letter == 'B') {
                    x -= dx[direction];
                    y -= dy[direction];

                    maxX = Math.max(x, maxX);
                    maxY = Math.max(y, maxY);
                    minX = Math.min(x, minX);
                    minY = Math.min(y, minY);
                } else if (letter == 'L') {
                    direction = (direction + 3) % 4;
                } else {
                    direction = (direction + 1) % 4;
                }
            }
            sb.append(Math.abs(maxX - minX) * Math.abs(maxY - minY)).append("\n");

        }

        System.out.println(sb);

        br.close();
    }
}