import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int max1 = 0;
        int max2 = 0;

        int result = 0;
        int dirBefore = 0;
        int valueBefore = 0;

        int list[][] = new int[7][2];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        list[6][0] = list[0][0];
        list[6][1] = list[0][1];

        for (int i = 0; i < 7; i++) {

            int dir = list[i][0];
            int value = list[i][1];

            if (dir == 1 || dir == 2) {
                max1 = Math.max(max1, value);
            } else {
                max2 = Math.max(max2, value);
            }
            boolean flag = true;
            if (dirBefore == 1) {
                if (dir != 4) {
                    flag = false;
                }
            } else if (dirBefore == 2) {
                if (dir != 3) {
                    flag = false;
                }
            } else if (dirBefore == 3) {
                if (dir != 1) {
                    flag = false;
                }
            } else if (dirBefore == 4) {
                if (dir != 2) {
                    flag = false;
                }
            }
            dirBefore = dir;
            if (!flag) {
                result = valueBefore * value;
            }
            valueBefore = value;
        }

        System.out.println(((max1 * max2) - result) * N);

        br.close();
    }

}