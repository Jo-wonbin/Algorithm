import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int times = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while (cnt++ < times) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            Deque<Integer> dq = new ArrayDeque<>();

            int index = 0;
            int flag = -1;

            while (index < N) {
                if (flag == -1) {
                    dq.addFirst(arr[index]);
                } else {
                    dq.addLast(arr[index]);
                }
                flag *= -1;
                index++;
            }

            int max = -1;
            int c = 0;
            int firstIndex = dq.peekFirst();
            int lastIndex = dq.peekLast();
            while (c < N - 1) {
                int a = dq.pollFirst();
                int b = dq.peekFirst();
                max = Math.max(Math.abs(a - b), max);
                c++;
            }
            max = Math.max(Math.abs(firstIndex - lastIndex), max);
            sb.append(max).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}