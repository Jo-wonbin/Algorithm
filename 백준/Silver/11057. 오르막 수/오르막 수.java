import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        final long DIV = 10007L;

        long arr[][] = new long[N + 1][10];

        long result = 0;
        if (N >= 2) {
            for (int i = 0; i < 10; i++) {
                arr[1][i] = 1L;
                arr[2][i] = 10L - i;
            }

            for (int i = 3; i <= N; i++) {

                int temp = 9;
                arr[i][temp] = 1L;
                for (int j = 8; j >= 0; j--) {
                    long value = 0L;
                    int cnt = 9;
                    while (cnt >= j) {
                        value = ((value % DIV) + (arr[i - 1][cnt] % DIV)) % DIV;
                        cnt--;
                    }

                    arr[i][j] = value % DIV;
                }
            }

            for (int i = 0; i < 10; i++) {
                result += arr[N][i] % DIV;
            }
        } else {
            result = 10;
        }

        System.out.println(result % DIV);
        br.close();
    }
}