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

        int arr[] = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == y)
                continue;
            reverse(x - 1, y - 1, arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int temp : arr) {
            sb.append(temp).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    private static void reverse(int start, int end, int arr[]) {
        int temp[] = new int[end - start + 1];
        int index = 0;
        for (int i = end; i >= start; i--) {
            temp[index++] = arr[i];
        }
        index = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = temp[index++];
        }
    }
}