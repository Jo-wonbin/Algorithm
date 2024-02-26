import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long temp = 1L;
        long result = 0L;
        while (N >= temp) {
            N -= temp;
            temp++;
            result++;
        }

        System.out.println(result);
        br.close();
    }
}