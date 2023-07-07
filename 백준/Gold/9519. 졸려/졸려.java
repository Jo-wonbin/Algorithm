import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        String word = br.readLine();
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        front.append(word);

        Set<String> set = new HashSet<>();
        set.add(word);
        int cnt = 1;

        while (cnt <= X) {

            char[] temp = front.toString().toCharArray();
            front.setLength(0);
            back.setLength(0);

            for (int j = 0; j < temp.length; j++) {
                if (j % 2 == 0) {
                    front.append(temp[j]);
                } else {
                    back.append(temp[j]);
                }
            }
            front.append(back.reverse());
            if (set.contains(front.toString())) {
                X = X % cnt;
                cnt = 1;
                continue;
            }
            cnt++;
        }

        System.out.println(front);
        br.close();
    }

}