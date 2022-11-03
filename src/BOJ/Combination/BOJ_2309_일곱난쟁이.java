package BOJ.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2309_일곱난쟁이 {

    static StringBuilder sb = new StringBuilder();
    static int arr[];
    static int result[];
    static boolean check[];
    static int flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        arr = new int[9];
        result = new int[7];
        check = new boolean[9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        flag = 0;
        Combination(0, 0, 0);

        System.out.println(sb);
        br.close();
    }

    static void Combination(int cnt, int temp, int num) {
        if (cnt == 7) {

            if (temp != 100)
                return;

            if(flag > 0)
                return;

            Arrays.sort(result);

            for (int i = 0; i < 7; i++) {
                sb.append(result[i]).append("\n");
            }

            flag++;

            return;
        }

        for (int i = num; i < 9; i++) {
            if (check[i])
                continue;
            result[cnt] = arr[i];
            check[i] = true;
            Combination(cnt + 1, temp + arr[i], i + 1);
            check[i] = false;
        }
    }
}
