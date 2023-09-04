import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int map[][] = new int[20][20];

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 오목 완성 여부 판단 변수
        boolean draw = true;

        // 돌 하나하나 오목이 되는지 검사하는 완전탐색
        Loop1:
        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {

                // 현재 칸이 검은 돌이거나 흰 돌일 경우
                if (map[i][j] != 0) {
                    // 오목이 기준 인덱스에서 어느 한 방향이라도 작동시 오목이 되었다 확인.
                    if (findFiveStone(map, i, j)) {
                        System.out.println(map[i][j]);
                        System.out.println(i + " " + j);
                        draw = false;
                        break Loop1;
                    }
                }
            }
        }

        // 오목이 되지 않은 경우
        if (draw) {
            System.out.println("0");
        }

        br.close();
    }

    static boolean findFiveStone(int[][] map, int x, int y) {
        int value = map[x][y];

        // 각 변수는 방향별 오목을 체크할 카운트변수 오목시 cnt = 5
        int cnt1 = 1;
        int cnt2 = 1;
        int cnt3 = 1;
        int cnt4 = 1;


        // 세로 줄 검사 - 기준 인덱스의 위 인덱스가 같은 돌이 아닐 때 작동
        int dx = x;

        if (x == 1 || (dx - 1 >= 1 && map[dx - 1][y] != value)) {
            while (true) {
                dx += 1;
                if (dx > 19) break;
                if (map[dx][y] != value) break;
                cnt1++;
            }
        }

        // 가로 줄 검사 - 기준 인덱스의 왼쪽 인덱스가 같은 돌이 아닐 때 작동
        int dy = y;
        if (y == 1 || (dy - 1 >= 1 && map[x][dy - 1] != value)) {
            while (true) {
                dy += 1;
                if (dy > 19) break;
                if (map[x][dy] != value) break;
                cnt2++;
            }
        }

        // 오른쪽 대각선 아래 검사 - 기준 인덱스의 왼쪽 위 인덱스가 같은 돌이 아닐 때 작동
        dx = x;
        dy = y;
        if (x == 1 || y == 1 || (dx - 1 >= 1 && dy - 1 >= 1 && map[dx - 1][dy - 1] != value)) {
            while (true) {
                dx += 1;
                dy += 1;

                if (dy > 19 || dx > 19) break;
                if (map[dx][dy] != value) break;
                cnt3++;
            }
        }

        // 오른쪽 대각선 위 검사 - 기준 인덱스의 왼쪽 아래 인덱스가 같은 돌이 아닐 때 작동
        dx = x;
        dy = y;
        if (x == 19 || y == 1 || (dx + 1 <= 19 && dy - 1 >= 1 && map[dx + 1][dy - 1] != value)) {
            while (true) {
                dx -= 1;
                dy += 1;

                if (dy > 19 || dx < 1) break;
                if (map[dx][dy] != value) break;
                cnt4++;
            }

        }

        if (cnt1 == 5 || cnt2 == 5 || cnt3 == 5 || cnt4 == 5) {
            return true;
        }

        return false;
    }
}