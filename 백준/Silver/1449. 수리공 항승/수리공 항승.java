import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int water[] = new int[N];
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water);

        int index = 1;
        int lastTaping = water[0];
        int tapeLength = L - 1;
        int result = 1;
        while (index < N) {
            if (tapeLength < water[index] - lastTaping) {
                result++;
                tapeLength = L-1;
            }else{
                tapeLength -= water[index] - lastTaping;
            }
            lastTaping = water[index];
            index++;
        }

        System.out.println(result);
        br.close();
    }
}