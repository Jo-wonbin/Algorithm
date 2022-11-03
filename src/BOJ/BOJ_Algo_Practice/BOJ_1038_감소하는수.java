package BOJ.BOJ_Algo_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1038_감소하는수 {

    static long N;
    static long result;
    static int temp[];
    static boolean chk[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        if (N - 10 < 0) {
            System.out.print(N);
        } else {
            result = 9;
            for (int i = 2; i <= 10; i++) {
                temp = new int[i];
                chk = new boolean[10];
                if (result == N)
                    break;
                find(0, i);
            }
        }
        if(N > 9 && result < N){
            System.out.print("-1");
        }
        br.close();
    }

    private static void find(int cnt, int digit) {

        if (cnt == digit) {
            result++;
            if (result == N) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < temp.length; i++) {
                    sb.append(temp[i]);
                }
                System.out.print(sb);
            }
            return;
        }


        for (int i = 0; i <= 9; i++) {
            if (chk[i])
                continue;
            if (cnt == 0 && i == 0)
                continue;
            if (cnt != 0){
                if(temp[cnt - 1] <= i){
                    continue;
                }
            }
            chk[i] = true;
            temp[cnt] = i;
            find(cnt + 1, digit);
            chk[i] = false;
        }
    }
}
