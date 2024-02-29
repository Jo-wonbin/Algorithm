import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> {
            if (map.get(o1) == (map.get(o2))) {
                return o1.compareTo(o2);
            }
            return map.get(o2).compareTo(map.get(o1));
        });

        System.out.println(keySet.get(0));
        br.close();
    }
}