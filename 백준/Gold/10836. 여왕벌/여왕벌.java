import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] houseOfBee;
    static int[] dx = {0, -1, -1};
    static int[] dy = {-1, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        houseOfBee = new int[M][M];

        int growth[] = new int[2 * M - 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            int index = zero;
            int cnt = 0;
            while (cnt < one) {
                growth[index] += 1;
                index++;
                cnt++;
            }
            cnt = 0;
            while (cnt < two) {
                growth[index] += 2;
                index++;
                cnt++;
            }

        }

        firstGrowUp(growth);
        secondGrowUp();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(houseOfBee[i][j] + 1).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void firstGrowUp(int growth[]) {
        int x = M - 1;
        int y = 0;

        int index = 0;
        while (index < 2 * M - 1) {

            houseOfBee[x][y] += growth[index];

            if (x == 0) {
                y++;
            } else {
                x--;
            }
            index++;
        }
    }

    private static void secondGrowUp() {

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                houseOfBee[i][j] = Math.max(houseOfBee[i + dx[0]][j + dy[0]], Math.max(houseOfBee[i + dx[1]][j + dy[1]], houseOfBee[i + dx[2]][j + dy[2]]));
            }
        }
    }

}