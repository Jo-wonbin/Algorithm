import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String tp = br.readLine();
            map1.put(i, tp);
            map2.put(tp, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            String temp = br.readLine();
            if (temp.charAt(0) - '0' >= 0 && temp.charAt(0) - '0' <= 9) {
                sb.append(map1.get(Integer.parseInt(temp))).append("\n");
            } else {
                sb.append(map2.get(temp)).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

}