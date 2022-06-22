package BOJweek8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 2][2];

        int dp[] = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            int temp = i + arr[i][0];
            if (temp <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dp[temp] + arr[i][1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);

        br.close();
    }
}
