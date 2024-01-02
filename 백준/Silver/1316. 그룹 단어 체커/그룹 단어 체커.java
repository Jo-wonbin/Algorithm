import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int length = word.length();
            boolean checkLetters[] = new boolean[26];
            char nowLetter = word.charAt(0);
            checkLetters[nowLetter - 97] = true;

            int tempLength = 1;
            for (int j = 1; j < word.length(); j++) {
                char letter = word.charAt(j);
                if (nowLetter != letter) {
                    int index = letter - 97;
                    if (!checkLetters[index]) {
                        checkLetters[index] = true;
                        nowLetter = letter;
                    } else {
                        break;
                    }
                }
                tempLength++;
            }

            if (length == tempLength)
                result++;
        }

        System.out.println(result);

        br.close();
    }
}