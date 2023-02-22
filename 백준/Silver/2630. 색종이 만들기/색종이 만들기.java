import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, countWhite, countRed;
    static boolean map[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) > 0 ? true : false;
            }
        }


        dividePaper(N, 0, 0);

        System.out.println(countWhite);
        System.out.println(countRed);

        br.close();

    }

    static void dividePaper(int length, int x, int y) {

        boolean flag = true;
        boolean color = map[x][y];
        Loop1:
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (map[i][j] != color) {
                    flag = false;
                    break Loop1;
                }
            }
        }

        if (flag) {
            if (color)
                countRed++;
            else
                countWhite++;
            return;
        }

        if (N > 1) {
            dividePaper(length / 2, x, y);
            dividePaper(length / 2, x + (length / 2), y);
            dividePaper(length / 2, x, y + (length / 2));
            dividePaper(length / 2, x + (length / 2), y + (length / 2));
        }
    }
}