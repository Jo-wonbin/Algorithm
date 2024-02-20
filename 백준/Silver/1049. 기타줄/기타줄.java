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

        int minSix = 1001;
        int minOne = 1001;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minSix = Math.min(minSix, Integer.parseInt(st.nextToken()));
            minOne = Math.min(minOne, Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        if (N >= 6) {
            result += minSix * (N / 6) <= minOne * (N / 6) * 6 ? minSix * (N / 6) : minOne * (N / 6) * 6;
        }
        int temp = N % 6;
        result += minSix <= minOne * temp ? minSix : minOne * temp;

        System.out.println(result);
        br.close();
    }
}