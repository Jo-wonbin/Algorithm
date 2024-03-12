import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        StringTokenizer st1 = new StringTokenizer(word, ".");
        StringTokenizer st2 = new StringTokenizer(word, "X");

        int flag = word.charAt(0) == 'X' ? -1 : 1;
        StringBuilder sb = new StringBuilder();
        int size = st1.countTokens() + st2.countTokens();
        int cnt = 0;
        while (cnt++ < size) {
            if (flag == -1) {
                int length = st1.nextToken().length();
                if (length % 2 == 1) {
                    System.out.println(-1);
                    return;
                }
                if (length / 4 > 0) {
                    int count = length / 4;
                    for (int i = 0; i < count; i++) {
                        sb.append("AAAA");
                    }
                }
                length %= 4;
                if (length > 0)
                    sb.append("BB");

            } else {
                sb.append(st2.nextToken());
            }
            flag *= -1;
        }

        System.out.println(sb);
        br.close();
    }

}