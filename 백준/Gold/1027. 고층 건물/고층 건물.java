import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] size = new int[N];

        for (int i = 0; i < N; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        // 기준 빌딩
        for (int i = 0; i < N; i++) {
            int count = 0;
            // 찾을 빌딩
            for (int j = 0; j < N; j++) {

                // 중복 제거
                if (i == j) {
                    continue;
                }

                // 거리가 1 차이나면 카운트 + 1
                if (Math.abs(i - j) == 1) {
                    count++;
                    continue;
                }
                double u = (size[j] - size[i]);
                double d = j - i;
                double line = u / d;

                boolean flag = true;

                if (i < j) {
                    // 우측
                    for (int z = i + 1; z <= j - 1; z++) {
                        double up = (size[z] - size[i]);
                        double down = z - i;
                        double temp = up / down;

                        if (Double.compare(line, temp) <= 0) {
                            flag = false;
                            break;
                        }

                    }
                } else {
                    //좌측
                    for (int z = j + 1; z <= i - 1; z++) {
                        double up = (size[z] - size[i]);
                        double down = z - i;
                        double temp = up / down;

                        if (Double.compare(line, temp) >= 0) {
                            flag = false;
                            break;
                        }

                    }
                }
                if (flag) {
                    count++;
                }

            }
            result = Math.max(result, count);
        }


        System.out.println(result);

        br.close();

    }

}