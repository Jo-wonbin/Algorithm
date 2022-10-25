package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10974_모든순열 {

    static int arr[];
    static boolean check[];
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new boolean[N];

        sb = new StringBuilder();

        Permutation(0);

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

        br.close();
    }

    static void Permutation(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i])
                continue;
            arr[cnt] = i + 1;
            check[i] = true;
            Permutation(cnt + 1);
            check[i] = false;
        }
    }
}
