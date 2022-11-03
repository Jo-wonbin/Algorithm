package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1799_비숍 {

    static int N;
    static int map[][];
    static boolean check[][];
    static boolean color[][];
    static int dx[] = {-1, -1};
    static int dy[] = {1, -1};
    static int b_cnt;
    static int w_cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        check = new boolean[N][N];
        color = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                color[i][j] = (i + j) % 2 == 0 ? true : false; // 흑 true , 백 false
            }
        }
        b_cnt = 0;
        w_cnt = 0;

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(color[i][j]+"  ");
//            }
//            System.out.println();
//        }

        Backtracking(-1, true, 0);
        Backtracking(-1, false, 0);

        System.out.println(b_cnt + w_cnt);

        br.close();
    }

    static void Backtracking(int index, boolean colorCheck, int count) {

        for (int i = index + 1; i < N * N; i++) {
            int x = i / N;
            int y = i % N;

            if (color[x][y] != colorCheck)
                continue;
            if (map[x][y] == 0)
                continue;
            if (!checkBishop(map, x, y))
                continue;

            check[x][y] = true;
            Backtracking(i, colorCheck, count + 1);
            check[x][y] = false;
        }
        if (colorCheck)
            b_cnt = Math.max(b_cnt, count);
        else
            w_cnt = Math.max(w_cnt, count);

    }

    static boolean checkBishop(int map[][], int x, int y) {

        for (int h = 0; h < 2; h++) {
            int rx = x + dx[h];
            int ry = y + dy[h];

            while (true) {
                if (rx < 0 || ry < 0 || rx > N - 1 || ry > N - 1)
                    break;
                if (check[rx][ry])
                    return false;
                rx += dx[h];
                ry += dy[h];
            }
        }

        return true;
    }
}



