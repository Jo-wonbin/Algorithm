import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static boolean map[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0' > 0 ? true : false;
            }
        }

        quadTree(N, 0, 0);

        System.out.println(sb);

        br.close();

    }

    static void quadTree(int length, int x, int y) {

        boolean flag = true;
        boolean number = map[x][y];
        Loop1:
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (map[i][j] != number) {
                    flag = false;
                    break Loop1;
                }
            }
        }

        if (flag) {
            if (number) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            return;
        }

        if (N > 1) {
            sb.append("(");
            quadTree(length / 2, x, y);
            quadTree(length / 2, x, y + (length / 2));
            quadTree(length / 2, x + (length / 2), y);
            quadTree(length / 2, x + (length / 2), y + (length / 2));
            sb.append(")");
        }
    }
}