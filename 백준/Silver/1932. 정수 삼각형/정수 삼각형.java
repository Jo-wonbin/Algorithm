import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][N];
        int dp[][] = new int[N][N];

        int size = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            size++;
        }

        dp[0][0] = arr[0][0];

        size = 2;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = (j == 0 ? dp[i - 1][j] : Math.max(dp[i - 1][j - 1], dp[i - 1][j])) + arr[i][j];
            }
            size++;
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);
        br.close();
    }
}