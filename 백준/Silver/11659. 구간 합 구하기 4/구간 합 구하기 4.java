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


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(sum[y] - sum[x - 1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}