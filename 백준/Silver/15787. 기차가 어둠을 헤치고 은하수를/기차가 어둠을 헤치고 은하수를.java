import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        int temp[] = new int[20];

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> tp = (ArrayList<Integer>) (Arrays.stream(temp).boxed().collect(Collectors.toList()));
            lists.add(tp);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int numberOfTrain = Integer.parseInt(st.nextToken()) - 1;
            int target = 0;
            if (st.hasMoreTokens()) {
                target = Integer.parseInt(st.nextToken()) - 1;
            }

            if (order == 1) {
                lists.get(numberOfTrain).set(target, 1);
            } else if (order == 2) {
                lists.get(numberOfTrain).set(target, 0);
            } else if (order == 3) {
                lists.get(numberOfTrain).remove(lists.get(numberOfTrain).size()-1);
                lists.get(numberOfTrain).add(0, 0);
            } else {
                lists.get(numberOfTrain).remove(0);
                lists.get(numberOfTrain).add(0);
            }
        }

        Set<String> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                sb.append(lists.get(i).get(j));
            }
            if (!set.contains(sb.toString())) {
                result++;
            }
            set.add(sb.toString());
        }

        System.out.println(result);
        br.close();
    }
}