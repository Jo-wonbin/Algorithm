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
        boolean flag = true;
        for (int i = 0; i < X; i++) {
            word = front.toString();
            front.setLength(0);
            back.setLength(0);

            char[] temp = word.toCharArray();

            for (int j = 0; j < temp.length; j++) {
                if (j % 2 == 0) {
                    front.append(temp[j]);
                } else {
                    back.append(temp[j]);
                }
            }
            front.append(back.reverse());
            if (set.contains(front.toString())) {
                flag = false;
                break;
            }
            cnt++;
        }
        if (!flag) {
            X = X % cnt;
            for (int i = 0; i < X; i++) {
                word = front.toString();
                front.setLength(0);
                back.setLength(0);

                char[] temp = word.toCharArray();

                for (int j = 0; j < temp.length; j++) {
                    if (j % 2 == 0) {
                        front.append(temp[j]);
                    } else {
                        back.append(temp[j]);
                    }
                }
                front.append(back.reverse());
            }
        }
        System.out.println(front);
        br.close();
    }

}