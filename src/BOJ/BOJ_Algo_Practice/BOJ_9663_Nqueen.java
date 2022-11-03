package BOJ.BOJ_Algo_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_Nqueen {

    static int N;
    static int map[];
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        result = 0;

        if (N == 1) {
            result = 1;
        } else {
            find(1);
        }

        System.out.println(result);
        br.close();
    }

    private static boolean check(int cnt) {

        // 첫번째는 통과
        if (cnt == 1) {
            return true;
        } else {
            for (int i = 1; i < cnt; i++) {
                // 상하좌우에 퀸이 있을때
                if (map[cnt] == map[i]) {
                    return false;
                }
                // 대각선에 퀸이 있을 때
                else if (Math.abs(cnt - i) == Math.abs(map[cnt] - map[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void find(int cnt) {
        if (cnt == N + 1) {
            result++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            map[cnt] = i;
            if (check(cnt)) {
                find(cnt + 1);
            }
        }

    }


}
