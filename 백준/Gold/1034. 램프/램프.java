import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Map<String, Integer> row = new HashMap<>();
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int zero = 0;
            for (int j = 0; j < M; j++) {
                if (arr[i].charAt(j) == '0')
                    zero++;
            }

            if (K >= zero && zero % 2 == K % 2)
                row.put(arr[i], row.getOrDefault(arr[i], 0) + 1);
        }

        List<String> str = new ArrayList<>(row.keySet());
        Collections.sort(str, (a1, a2) -> row.get(a2).compareTo(row.get(a1)));

        if (str.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(row.get(str.get(0)));
        }

        br.close();
    }

}