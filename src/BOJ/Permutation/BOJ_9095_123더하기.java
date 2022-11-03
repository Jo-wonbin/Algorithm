package BOJ.Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9095_123더하기 {

    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            answer = 0;

            Permutation(0);

            sb.append(answer).append("\n");

        }
        System.out.println(sb);

        br.close();
    }

    static void Permutation(int temp) {
        if (temp > n) {
            return;
        }

        if (temp == n) {
            answer++;
            return;
        }

        Permutation(temp + 1);

        Permutation(temp + 2);

        Permutation(temp + 3);
    }
}
