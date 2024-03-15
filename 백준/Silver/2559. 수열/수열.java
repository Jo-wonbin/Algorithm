import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum[] = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int sumAll = 0;
        for (int i = 1; i <= N; i++) {
            sumAll += Integer.parseInt(st.nextToken());
            sum[i] = sumAll;
        }

        int max = Integer.MIN_VALUE;
        for (int i = M; i <= N; i++) {
            max = Math.max(sum[i] - sum[i - M], max);
        }

        System.out.println(max);
        br.close();
    }

}