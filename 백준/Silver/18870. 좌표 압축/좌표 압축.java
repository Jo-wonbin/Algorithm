import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<Integer> sort = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int size = 0;
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            list.add(now);
            set.add(now);

            if (size != set.size()) {
                size++;
                sort.add(now);
            }
        }
        Collections.sort(sort);

        StringBuilder sb = new StringBuilder();

        for (int i : list) {

            int start = 0;
            int end = sort.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int now = sort.get(mid);

                if (now == i) {
                    sb.append(mid).append(" ");
                    break;
                } else if (now < i) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}