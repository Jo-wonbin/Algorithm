import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int dot = 46;
        int space = 32;
        int dots[] = new int[10];
        int spaces[] = new int[10];
        int hexMessage[] = new int[N];
        for (int i = 0; i < N; i++) {
            hexMessage[i] = Integer.parseInt(st.nextToken(), 16);
        }
        for (int i = 0; i < 10; i++) {
            dots[i] = dot ^ (48 + i);
            spaces[i] = space ^ (48 + i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int msg = hexMessage[i];
            boolean flag = false;
            for (int j = 0; j < 10; j++) {
                if (msg == dots[j] || msg == spaces[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) sb.append(".");
            else sb.append("-");
        }

        System.out.println(sb);
        br.close();
    }
}