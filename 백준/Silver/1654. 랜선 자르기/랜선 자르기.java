import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int K, N;
    static int LanLines[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        LanLines = new int[K];

        for (int i = 0; i < K; i++) {
            LanLines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(LanLines);

        // 최소로 나눌 수 있는 길이
        long start = 1L;
        // 최대로 나눌 수 있는 길이
        long end = (long)LanLines[K - 1] + 1;

        while (start + 1 < end) {
            long mid = (start + end) / 2;

            if (cutLines(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);

        br.close();

    }

    // 선 나누기
    static boolean cutLines(long mid) {
        long sum = 0;

        for (int i = 0; i < K; i++) {
            long temp = (long) LanLines[i] / mid;

            sum += temp;
        }

        return sum >= N;
    }
}