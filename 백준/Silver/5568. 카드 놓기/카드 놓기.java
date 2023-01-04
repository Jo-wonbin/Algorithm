import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, count;
    static boolean[] visited;
    static boolean[] numCheck;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new String[N];
        numCheck = new boolean[100000000];
        visited = new boolean[N + 1];
        int cnt = 0;

        while (cnt < N) {
            arr[cnt++] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        count = 0;

        find(0, sb);

        System.out.println(count);

        br.close();
    }

    static void find(int cnt, StringBuilder sb) {
        if (cnt == K) {
            int temp = Integer.parseInt(sb.toString());
            if (!numCheck[temp]) {
                numCheck[temp] = true;
                count++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            sb.append(arr[i]);
            find(cnt + 1, sb);
            sb.setLength(sb.length() - arr[i].length());
            visited[i] = false;


        }
    }


}