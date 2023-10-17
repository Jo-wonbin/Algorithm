import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] houseOfBee;
    static int[][] BeforeHouse;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        houseOfBee = new int[M][M];
        BeforeHouse = new int[M][M];

        for (int i = 0; i < M; i++) {
            Arrays.fill(houseOfBee[i], 1);
            Arrays.fill(BeforeHouse[i], 1);
        }

        int growth[][] = new int[N][2 * M - 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            int cnt = zero + one;
            int index = zero;
            while (index < cnt) {
                growth[i][index] = 1;
                index++;
            }
            cnt += two;
            while (index < cnt) {
                growth[i][index] = 2;
                index++;
            }

            firstGrowUp(growth[i]);
            secondGrowUp();
            AfterToBeforeHouse();
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(houseOfBee[i][j]).append(" ");
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
        int x = 1;
        int y = 1;
        int start = 2;
        while (x <= M - 1 && y <= M - 1) {
            findFourDirection(x, y);

            if (start >= M)
                break;

            for (int i = start; i < M; i++) {
                findFourDirection(x, i);
                findFourDirection(i, y);
            }
            x++;
            y++;
            start++;
        }
    }

    private static void findFourDirection(int x, int y) {
        int sum = 0;
        for (int h = 0; h < 4; h++) {
            int nx = x + dx[h];
            int ny = y + dy[h];

            if (nx < 0 || ny < 0 || nx >= M || ny >= M)
                continue;
            sum = Math.max(houseOfBee[nx][ny] - BeforeHouse[nx][ny], sum);

        }
        houseOfBee[x][y] += sum;
    }

    private static void AfterToBeforeHouse() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                BeforeHouse[i][j] = houseOfBee[i][j];
            }
        }
    }
}