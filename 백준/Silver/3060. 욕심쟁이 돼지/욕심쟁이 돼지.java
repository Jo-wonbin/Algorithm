import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int times = 0; times < T; times++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int temp[] = new int[6];
            int cnt = 1;
            int sum = 0;

            for (int i = 0; i < 6; i++) {
                temp[i] = Integer.parseInt(st.nextToken());
                sum += temp[i];
            }

            if (sum > N) {
                sb.append(cnt).append("\n");
            } else {
                while (true) {
                    cnt++;
                    sum = 0;
                    int[] copy = temp.clone();
                    for (int i = 0; i < 6; i++) {
                        temp[i] = copy[i] + copy[(i + 5) % 6] + copy[(i + 1) % 6] + copy[(i + 3) % 6];
                        sum += temp[i];
                    }

                    if (sum > N) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }

        }

        System.out.println(sb);

        br.close();
    }

}