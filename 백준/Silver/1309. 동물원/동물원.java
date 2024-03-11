import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        final long DIV = 9901L;
        long dp[] = new long[N + 1];
        dp[1] = 3L;

        if (N > 1) {
            dp[2] = 7L;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] % DIV + dp[i - 1] % DIV + dp[i - 2] % DIV) % DIV;
            }
        }

        System.out.println(dp[N]);
        br.close();
    }

}