import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[N];
        temp = new int[M];

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while(cnt < N){
            arr[cnt++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        find(0);

        System.out.println(sb);

        br.close();
    }

    static void find(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            temp[cnt] = arr[i];
            find(cnt + 1);
            visited[i] = false;
        }
    }


}