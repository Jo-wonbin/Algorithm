import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            char[] before = br.readLine().toCharArray();
            char[] after = br.readLine().toCharArray();

            int beforeW = 0;
            int afterW = 0;
            int diffCnt = 0;
            for (int i = 0; i < N; i++) {
                if (before[i] != after[i]) diffCnt++;
                if (before[i] == 'W') beforeW++;
                if (after[i] == 'W') afterW++;
            }

            int temp = Math.abs(beforeW - afterW);
            int result = temp + (diffCnt - temp) / 2;

            sb.append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

}