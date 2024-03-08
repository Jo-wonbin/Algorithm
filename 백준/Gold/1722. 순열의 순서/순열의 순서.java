import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int flag = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        if (flag == 1) {
            long k = Long.parseLong(st.nextToken());
            int arr[] = new int[N + 1];
            boolean checked[] = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = i;
            }
            int cnt = 0;
            while (cnt < N) {

                long temp = N - 1 - cnt;
                long value = factorial(temp);
                for (int i = 1; i <= N; i++) {

                    if (k <= value * i) {
                        k -= value * (i - 1);
                        int num = findNum(checked, i);
                        sb.append(num).append(" ");
                        checked[num] = true;
                        break;
                    }
                }
                cnt++;
            }
            System.out.println(sb);
        } else {
            int arr[] = new int[N + 1];
            boolean checked[] = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long result = 0;
            for (int i = 1; i <= N; i++) {
                if (i < N) {
                    result += factorial(N - i) * (findCount(checked, arr[i]) - 1);
                } else {
                    result += 1;
                }
            }
            System.out.println(result);
        }

        br.close();
    }

    private static int findCount(boolean checked[], int arrNum) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (checked[i])
                continue;
            count++;
            if (arrNum == i) {
                checked[i] = true;
                return count;
            }
        }
        return count;
    }

    private static int findNum(boolean[] checked, int index) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (checked[i])
                continue;
            if (++cnt == index) {
                return i;
            }
        }
        return cnt;
    }


    private static long factorial(long n) {
        if (n == 0) {
            return 1L;
        } else if (n <= 2) {
            return n;
        } else {
            return n * factorial(n - 1);
        }
    }
}