import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N, K, count;
    static boolean[] visited;
    static Set<Integer> numCheck = new HashSet<>();
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new String[N];
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

            if (!numCheck.contains(temp)) {
                numCheck.add(temp);
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