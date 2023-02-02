import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String numbers[] = new String[N];
        int strikeBall[][] = new int[N][2];
        for (int k = 0; k < N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers[k] = st.nextToken();
            strikeBall[k][0] = Integer.parseInt(st.nextToken());
            strikeBall[k][1] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        // 백의 자리
        for (int i = 1; i <= 9; i++) {
            // 십의 자리
            for (int j = 1; j <= 9; j++) {
                // 일의 자리
                for (int z = 1; z <= 9; z++) {
                    // 중복된 수 나오면 패스
                    if (i == j || j == z || z == i)
                        continue;

                    boolean flag = true;
                    // 조건에 모두 맞아야 체크
                    for (int k = 0; k < N; k++) {
                        int strikeCount = 0;
                        int ballCount = 0;

                        if (numbers[k].charAt(0) - '0' == i)
                            strikeCount++;
                        if (numbers[k].charAt(1) - '0' == j)
                            strikeCount++;
                        if (numbers[k].charAt(2) - '0' == z)
                            strikeCount++;
                        if (numbers[k].charAt(0) - '0' == j || numbers[k].charAt(0) - '0' == z)
                            ballCount++;
                        if (numbers[k].charAt(1) - '0' == i || numbers[k].charAt(1) - '0' == z)
                            ballCount++;
                        if (numbers[k].charAt(2) - '0' == i || numbers[k].charAt(2) - '0' == j)
                            ballCount++;

                        if (strikeCount != strikeBall[k][0] || ballCount != strikeBall[k][1]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        result++;
                }
            }
        }


        System.out.println(result);

        br.close();

    }

}