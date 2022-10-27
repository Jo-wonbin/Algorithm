package Permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1339_단어수학 {

    static int N;
    static int arr[];
    static char voca[][];
    static boolean chk[];
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[10];
        voca = new char[N][8];
        chk = new boolean[10];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < temp.length(); j++) {
                voca[i][j] = temp.charAt(j);
            }

        }

        Permutation(0);
        System.out.println(answer);

        br.close();
    }

    static void Permutation(int cnt) {

        if (cnt == N) {
            int temp = 0;

            for (int i = 0; i < N; i++) {

                int count = 0;
                for (int j = 0; j < 8; j++) {
                    if (voca[i][j] == '\0')
                        break;
                    count++;
                }

                if (count == 0)
                    continue;

                int ten = count;
                for (int j = 0; j < count; j++) {
                    int num = voca[i][j] - 65;
                    if (arr[num] == 0)
                        continue;
                    int a = (int) Math.pow(10, ten - 1);
                    temp += (arr[num] * a);
                    ten--;
                }

            }
            answer = Math.max(answer, temp);

            return;
        }

        for (int i = 9; i >= 0; i--) {
            if (chk[i])
                continue;
            arr[cnt] = i;
            chk[i] = true;
            Permutation(cnt + 1);
            chk[i] = false;
        }
    }

}
