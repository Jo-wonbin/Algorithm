import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static char map[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = ' ';
            }
        }

        drawingStar(N, 0, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();

    }

    static void drawingStar(int length, int x, int y) {

        if (length == 1) {
            map[x][y] = '*';
            return;
        }
        int nowLength = length / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                drawingStar(nowLength, i * nowLength + x, j * nowLength + y);
            }
        }

    }

}