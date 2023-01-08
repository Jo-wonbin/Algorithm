import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static boolean[] visited;
    static char[] arr;
    static char[] temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[C];
        arr = new char[C];
        temp = new char[L];

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while (cnt < C) {
            arr[cnt++] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        find(0, 0);

        System.out.println(sb);

        br.close();
    }

    static void find(int cnt, int now) {
        if (cnt == L) {

            int Acnt = 0;
            int Bcnt = 0;
            for (int i = 0; i < L; i++) {
                char tp = temp[i];
                if (tp == 'a' || tp == 'e' || tp == 'i' || tp == 'o' || tp == 'u')
                    Acnt++;
                else
                    Bcnt++;
            }
            if (Acnt >= 1 && Bcnt >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(temp[i]);
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = now; i < C; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            temp[cnt] = arr[i];
            find(cnt + 1, i+1);
            visited[i] = false;
        }
    }


}