import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static int homes[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homes = new int[N];

        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homes);

        int start = 1;
        int end = homes[N - 1] - homes[0] + 1;

        while (start + 1 < end) {

            int mid = (start + end) / 2;

            if (countLength(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);

        br.close();

    }

    // 공유기 설치 후 갯수 비교
    static boolean countLength(int mid) {
        int count = 1;
        int lastLocation = homes[0];

        for (int i = 1; i < N; i++) {
            if(homes[i] - lastLocation >= mid){
                count++;
                lastLocation = homes[i];
            }
        }

        return count >= M;
    }
}