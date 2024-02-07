import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long arr[] = new long[N + 1];
        long result[] = new long[N + 1];


        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        result[0] = 0L;
        result[1] = arr[1];

        if (N > 1) {

            result[2] = arr[1] + arr[2];


            for (int i = 3; i <= N; i++) {
                result[i] = Math.max(result[i - 1], Math.max(result[i - 2] + arr[i], result[i - 3] + arr[i - 1] + arr[i]));
            }
        }
        System.out.println(result[N]);

        br.close();
    }

}