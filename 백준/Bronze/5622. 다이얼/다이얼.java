import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            int temp = word.charAt(i) - 'A';
            if (temp < 3) result += 3;
            else if (temp < 6) result += 4;
            else if (temp < 9) result += 5;
            else if (temp < 12) result += 6;
            else if (temp < 15) result += 7;
            else if (temp < 19) result += 8;
            else if (temp < 22) result += 9;
            else result += 10;
        }

        System.out.println(result);
        br.close();
    }

}