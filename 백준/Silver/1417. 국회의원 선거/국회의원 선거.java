import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }
        int[] list = new int[N - 1];
        int one = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int last = list.length - 1;
        while (true) {
            Arrays.sort(list);
            if (list[last] < one) {
                break;
            }
            list[last]--;
            one++;
            result++;
        }

        System.out.println(result);

        br.close();
    }

}