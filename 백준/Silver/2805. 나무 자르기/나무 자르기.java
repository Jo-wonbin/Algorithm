import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static int trees[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int start = 0;
        int end = trees[N - 1];

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (cuttingTrees(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);

        br.close();

    }

    // 높이 계산
    static boolean cuttingTrees(int mid) {
        long sum = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (trees[i] > mid) {
                sum += (trees[i] - mid);
            } else {
                break;
            }
        }

        return sum >= M;
    }
}