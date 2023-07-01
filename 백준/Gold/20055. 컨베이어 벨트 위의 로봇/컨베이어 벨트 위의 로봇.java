import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N + 1];
        boolean[] on = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;

        while (true) {
            // 1단계
            int temp = belt[2 * N];
            for (int i = 2 * N; i >= 2; i--) {
                belt[i] = belt[i - 1];
            }
            belt[1] = temp;

            for (int i = N; i >= 2; i--) {
                on[i] = on[i - 1];
            }
            on[N] = false;
            on[1] = false;

            // 2단계
            for (int i = N; i >= 2; i--) {
                if (!on[i] && belt[i] > 0 && on[i - 1]) {
                    belt[i]--;
                    on[i] = true;
                    on[i - 1] = false;
                }
            }
            on[N] = false;

            // 3단계
            if (belt[1] > 0) {
                belt[1]--;
                on[1] = true;
            }

            // 4단계
            int cnt = 0;
            for (int i = 1; i <= 2 * N; i++) {
                if (belt[i] == 0)
                    cnt++;
            }
            if (cnt >= K)
                break;

            answer++;
        }

        System.out.println(answer);

        br.close();
    }

}