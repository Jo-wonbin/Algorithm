import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int arr[];
    static int temp[];
    static boolean visited[];
    static int result, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;

        permutation(0);

        System.out.println(result);

        br.close();
    }

    private static void permutation(int cnt) {
        if (cnt == N) {
            int answer = 0;
            for (int i = 0; i < N - 1; i++) {
                answer += Math.abs(temp[i] - temp[i + 1]);
            }

            result = Math.max(result, answer);
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            temp[cnt] = arr[i];
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

}