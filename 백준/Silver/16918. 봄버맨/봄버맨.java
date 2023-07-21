import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        char[][] map = new char[H][W];
        int[][] bomb = new int[H][W];

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        for (int i = 0; i < H; i++) {
            String temp = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'O')
                    bomb[i][j] = 3;
            }
        }

        int cnt = 0;

        while (cnt++ < time) {


            if (cnt % 2 == 0) {

                // 이번에 설치한 폭탄
                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bomb[i][j] = cnt + 3;
                        }
                    }
                }
            } else {

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < W; j++) {
                        if (bomb[i][j] == cnt) {
                            map[i][j] = '.';
                            for (int h = 0; h < 4; h++) {
                                int nx = i + dx[h];
                                int ny = j + dy[h];

                                if (nx < 0 || ny < 0 || nx > H - 1 || ny > W - 1) {
                                    continue;
                                }
                                if (map[nx][ny] == 'O' && bomb[nx][ny] != cnt) {
                                    map[nx][ny] = '.';
                                    bomb[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}