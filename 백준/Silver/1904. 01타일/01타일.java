import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long arr[] = new long[N + 1];

        if (N <= 2) {
            System.out.println(N);
        } else {
            arr[1] = 1L;
            arr[2] = 2L;

            for (int i = 3; i <= N; i++) {
                arr[i] = ((arr[i - 1] % 15746L) + (arr[i - 2] % 15746L)) % 15746L;
            }

            System.out.println(arr[N]);
        }

        br.close();
    }

}