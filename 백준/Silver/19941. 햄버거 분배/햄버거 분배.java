import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean visited[] = new boolean[N];

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                for (int j = i - K; j <= i + K; j++) {
                    if (j < 0 || j > N - 1)
                        continue;
                    if (arr[j] == 'P')
                        continue;
                    if (visited[j])
                        continue;
                    visited[j] = true;
                    result++;
                    break;
                }
            }
        }


        System.out.println(result);

        br.close();
    }

}