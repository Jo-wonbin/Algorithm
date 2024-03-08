import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static class Alpa implements Comparable<Alpa> {
        char letter;
        int cnt;

        Alpa(char letter, int cnt) {
            this.letter = letter;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Alpa o) {
            return this.letter - o.letter;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        char[] word = br.readLine().toCharArray();

        int count[] = new int[26];
        for (int i = 0; i < word.length; i++) {
            count[word[i] - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = -1;
        List<Alpa> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
            }
            if (count[i] > 0)
                list.add(new Alpa((char) (65 + i), count[i]));
        }

        if (oddCount > 1) {
            sb.append("I'm Sorry Hansoo");
        } else {
            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).cnt % 2 == 1) {
                    oddIndex = i;
                    break;
                }
            }

            for (int i = 0; i < list.size(); i++) {
                Alpa now = list.get(i);

                for (int j = 0; j < now.cnt / 2; j++) {
                    sb.append(now.letter);
                }
            }
            if (oddIndex > -1) {
                sb.append(list.get(oddIndex).letter);
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                Alpa now = list.get(i);

                for (int j = 0; j < now.cnt / 2; j++) {
                    sb.append(now.letter);
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

}