import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N + 1][3];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.MAX_VALUE;
        for (int times = 0; times < 3; times++) {

            int dp[][] = new int[N + 1][3];
            dp[1][0] = 10000001;
            dp[1][1] = 10000001;
            dp[1][2] = 10000001;

            if (times == 0) dp[1][0] = arr[1][0];
            else if (times == 1) dp[1][1] = arr[1][1];
            else dp[1][2] = arr[1][2];

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
            }

            if (times == 0) {
                result = Math.min(result, Math.min(dp[N][1], dp[N][2]));
            } else if (times == 1) {
                result = Math.min(result, Math.min(dp[N][0], dp[N][2]));
            } else {
                result = Math.min(result, Math.min(dp[N][0], dp[N][1]));
            }
        }

        System.out.println(result);
        br.close();
    }

}