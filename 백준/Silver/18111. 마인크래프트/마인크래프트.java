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
        int B = Integer.parseInt(st.nextToken());

        int list[] = new int[N * M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                list[cnt++] = temp;
            }
        }

        int minTime = 1000000007;
        int heightOfLand = 0;

        Arrays.sort(list);
        int min = list[0];
        int max = list[list.length - 1];

        for (int i = min; i <= max; i++) {
            int land = B;
            int result = 0;
            boolean flag = true;

            for (int j = list.length - 1; j >= 0; j--) {
                if (land < 0) {
                    flag = false;
                    break;
                }
                int temp = list[j];

                if (temp > i) {
                    land += temp - i;
                    result += ((temp - i) << 1);
                } else if (temp < i) {
                    if (land >= i - temp) {
                        land -= (i - temp);
                        result += (i - temp);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                if (minTime >= result) {
                    minTime = result;
                    if (heightOfLand < i) {
                        heightOfLand = i;
                    }
                }
            }
        }
        System.out.println(minTime + " " + heightOfLand);

        br.close();
    }
}