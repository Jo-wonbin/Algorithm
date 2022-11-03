package BOJ.BOJ_Algo_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5566_주사위게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int board[] = new int[N + 1];
        int dice[] = new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int now = 1;
        int result = 0;
        for (int i = 0; i < M; i++) {
            now += dice[i];

            if (now >= N) {
                result = i + 1;
                break;
            }

            now += board[now];
            if (now >= N) {
                result = i + 1;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }

}
