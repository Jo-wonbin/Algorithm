import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!set.contains(temp)) {
                set.add(temp);
                list.add(temp);
            }
        }
        Collections.sort(list);

        List<Integer> dp = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            dp.add(list.get(i + 1) - list.get(i));
        }
        int result = 0;
        if (dp.size() == 0 || N <= K) {
            result = 0;
        } else {
            Collections.sort(dp);
            while (!dp.isEmpty() && K > 1) {
                dp.remove(dp.size() - 1);
                K--;
            }
            for (int value : dp) {
                result += value;
            }
        }

        System.out.println(result);
        br.close();
    }
}