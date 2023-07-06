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
        int result = 0;

        st = new StringTokenizer(br.readLine());

        int map[] = new int[M];
        for (int i = 0; i < M; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < M - 1; i++) {
            int now = max(map, i, N, M);
            if (max(map, i, N, M) > map[i]) {
                result += (now - map[i]);
            }
        }

        System.out.println(result);

        br.close();
    }

    public static int max(int[] map, int index, int N, int M) {
        int lmax = 0, rmax = 0;
        for (int i = 0; i < index; i++) {
            lmax = Math.max(lmax, map[i]);
        }

        for (int i = index + 1; i < M; i++) {
            rmax = Math.max(rmax, map[i]);
        }

        return lmax < rmax ? lmax : rmax;
    }
}