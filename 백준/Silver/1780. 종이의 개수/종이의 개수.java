import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, minus, zero, one;
    static int map[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minus = 0;
        zero = 0;
        one = 0;

        dividePaper(N, 0, 0);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

        br.close();

    }

    static void dividePaper(int length, int x, int y) {

        boolean flag = true;
        int number = map[x][y];
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
            if (number == -1) {
                minus++;
            } else if (number == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }

        if (length > 1) {
            int temp = length / 3;
            dividePaper(temp, x, y);
            dividePaper(temp, x, y + temp);
            dividePaper(temp, x, y + (temp * 2));
            dividePaper(temp, x + temp, y);
            dividePaper(temp, x + temp, y + temp);
            dividePaper(temp, x + temp, y + (temp * 2));
            dividePaper(temp, x + (temp * 2), y);
            dividePaper(temp, x + (temp * 2), y + temp);
            dividePaper(temp, x + (temp * 2), y + (temp * 2));

        }
    }
}