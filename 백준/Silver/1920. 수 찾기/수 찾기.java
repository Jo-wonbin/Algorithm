import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int list[] = new int[M];
        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int temp = list[i];

            int left = 0;
            int right = N - 1;
            boolean flag = false;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] < temp) {
                    left = mid + 1;
                } else if (arr[mid] > temp) {
                    right = mid - 1;
                } else {
                    flag = true;
                    break;
                }

            }
            if (flag) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        }

        System.out.print(sb.toString());

        br.close();

    }


}