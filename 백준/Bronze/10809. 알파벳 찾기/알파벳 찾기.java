import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int arr[] = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (arr[index] > -1)
                continue;
            arr[index] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int temp : arr) {
            sb.append(temp).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

}