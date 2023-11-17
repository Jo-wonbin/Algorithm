import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean alpabet[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        alpabet = new boolean[27];

        int times = 0;
        while (times < N) {
            String temp = br.readLine();
//            System.out.println(temp);

            String word[] = temp.split(" ");
            boolean done = false;

            int wordIndex = -1;
            int letterIndex = -1;


            for (int i = 0; i < word.length; i++) {
                int firstLetterIndex = word[i].substring(0, 1).toUpperCase().charAt(0) - 65;
                if (!alpabet[firstLetterIndex]) {
                    alpabet[firstLetterIndex] = true;
                    wordIndex = i;
                    letterIndex = 0;
                    done = true;
                    break;
                }
            }


            if (!done) {
                Loop1:
                for (int i = 0; i < word.length; i++) {
                    for (int j = 1; j < word[i].length(); j++) {

                        int secondLetterIndex = word[i].substring(j, j + 1).toUpperCase().charAt(0) - 65;
                        if (!alpabet[secondLetterIndex]) {
                            alpabet[secondLetterIndex] = true;
                            wordIndex = i;
                            letterIndex = j;
                            break Loop1;
                        }
                    }
                }
            }

            for (int i = 0; i < word.length; i++) {
                if (wordIndex == i) {
                    for (int j = 0; j < word[i].length(); j++) {
                        if (j != letterIndex) {
                            sb.append(word[i].charAt(j));
                        } else {
                            sb.append("[").append(word[i].charAt(j)).append("]");
                        }
                    }
                    sb.append(" ");
                } else {
                    sb.append(word[i]).append(" ");
                }
            }
            sb.append("\n");
            times++;
        }

        System.out.println(sb);

        br.close();
    }

}