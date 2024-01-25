import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int z = 0; z < N; z++) {
            char[] temp = br.readLine().toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            int cursorIndex = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == '<') {
                    cursorIndex = cursorIndex > 0 ? cursorIndex - 1 : cursorIndex;
                } else if (temp[i] == '>') {
                    cursorIndex = cursorIndex < list.size() ? cursorIndex + 1 : cursorIndex;
                } else if (temp[i] == '-') {
                    if (cursorIndex > 0)
                        list.remove(--cursorIndex);
                } else {
                    list.add(cursorIndex++, temp[i]);
                }
            }
            while (!list.isEmpty()) {
                sb.append(list.pollFirst());
            }
            sb.append("\n");
        }


        System.out.println(sb);
        br.close();
    }


}