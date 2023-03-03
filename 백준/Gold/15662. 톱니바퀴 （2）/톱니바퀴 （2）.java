import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int N, K;
    static int gear[][];
    static int poleOfGear[][];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        gear = new int[N + 1][8];
        poleOfGear = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i + 1][j] = temp.charAt(j) - '0';
            }
            poleOfGear[i + 1][0] = 2;
            poleOfGear[i + 1][1] = 6;

        }

        K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());
            visited = new boolean[N + 1];
            rollTheGear(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) == 1 ? true : false);

        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (gear[i][(poleOfGear[i][0] + 6) % 8] == 1)
                count++;
        }

        System.out.println(count);

        br.close();

    }

    static void rollTheGear(int gearNumber, boolean direction) {

        visited[gearNumber] = true;

        if (gearNumber > 1) {
            if (check(gearNumber, gearNumber - 1) && !visited[gearNumber - 1]) {
                rollTheGear(gearNumber - 1, !direction);
            }
        }

        if (gearNumber < N) {
            if (check(gearNumber, gearNumber + 1) && !visited[gearNumber + 1]) {
                rollTheGear(gearNumber + 1, !direction);
            }
        }

        rotation(gearNumber, direction);
    }

    static boolean check(int nowGear, int nextGear) {
        // 우측 기어 체크
        if (nowGear < nextGear) {
            //비교
            if (gear[nowGear][poleOfGear[nowGear][0]] != gear[nextGear][poleOfGear[nextGear][1]]) {
                return true;
            }
        }
        // 좌측 기어 체크
        else {
            //비교
            if (gear[nowGear][poleOfGear[nowGear][1]] != gear[nextGear][poleOfGear[nextGear][0]]) {
                return true;
            }
        }

        return false;
    }

    static void rotation(int gearNumber, boolean direction) {
        // 시계 방향
        if (direction) {
            poleOfGear[gearNumber][0] = (poleOfGear[gearNumber][0] + 7) % 8;
            poleOfGear[gearNumber][1] = (poleOfGear[gearNumber][1] + 7) % 8;

        }
        // 반시계 방향
        else {
            poleOfGear[gearNumber][0] = (poleOfGear[gearNumber][0] + 1) % 8;
            poleOfGear[gearNumber][1] = (poleOfGear[gearNumber][1] + 1) % 8;
        }

    }


}