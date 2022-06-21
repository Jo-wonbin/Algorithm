package BOJweek8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579_계단오르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[301];
        int dp[] = new int[301];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(dp[1], arr[2]) + arr[3];

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[N]);

        br.close();

    }
}
