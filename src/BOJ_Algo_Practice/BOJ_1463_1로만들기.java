package BOJ_Algo_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int arr[] = new int[X + 1];
        for (int i = 2; i <= X; i++) {
            int minus;
            int second = Integer.MAX_VALUE;
            int third = Integer.MAX_VALUE;

            if (i % 3 == 0)
                third = arr[i / 3] + 1;
            if (i % 2 == 0)
                second = arr[i / 2] + 1;

            minus = arr[i - 1] + 1;

            int result = Math.min(Math.min(third, second), minus);

            arr[i] = result;
        }

        System.out.println(arr[X]);

        br.close();
    }
}
