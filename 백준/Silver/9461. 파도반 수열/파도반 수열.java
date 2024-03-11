import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long arr[] = new long[101];
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        arr[4] = 2L;
        arr[5] = 2L;
        for (int i = 6; i <= 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        StringBuilder sb = new StringBuilder();
        for (int times = 0; times < T; times++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}