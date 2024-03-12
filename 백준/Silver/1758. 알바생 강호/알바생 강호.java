import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long arr[] = new Long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long result = 0;
        for (int i = 0; i < N; i++) {
            long temp = arr[i] - i;
            if (temp > 0)
                result += temp;
        }

        System.out.println(result);
        br.close();
    }

}