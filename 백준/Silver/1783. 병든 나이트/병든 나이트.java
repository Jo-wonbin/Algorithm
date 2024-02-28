import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 1;
        if (N > 2) {
            if (M > 4) {
                result = 4 > M - 2 ? 4 : M - 2;
            } else {
                result = M;
            }
        } else if (N == 2) {
            if (M / 2 > 4) {
                result = 4;
            } else {
                if (M == 3) {
                    result = 2;
                } else if (M / 2 > 4) {
                    result = 4;
                } else {
                    if (M % 2 == 1)
                        result = M / 2 + 1;
                    else
                        result = M / 2;
                }
            }
        }

        System.out.println(result);
        br.close();
    }
}