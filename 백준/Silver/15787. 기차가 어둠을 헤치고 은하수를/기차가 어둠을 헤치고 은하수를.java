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

        int trains[] = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int numberOfTrain = Integer.parseInt(st.nextToken()) - 1;


            if (order == 1) {
                int target = Integer.parseInt(st.nextToken()) - 1;
                trains[numberOfTrain] |= (1 << target);
            } else if (order == 2) {
                int target = Integer.parseInt(st.nextToken()) - 1;
                trains[numberOfTrain] &= ~(1 << target);
            } else if (order == 3) {
                if ((trains[numberOfTrain] & (1 << 19)) != 0)
                    trains[numberOfTrain] &= ~(1 << 19);
                trains[numberOfTrain] <<= 1;
            } else {
                if ((trains[numberOfTrain] & 1) != 0)
                    trains[numberOfTrain] &= ~1;
                trains[numberOfTrain] >>= 1;
            }
        }

        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            if (!set.contains(trains[i])) {
                result++;
            }
            set.add(trains[i]);
        }

        System.out.println(result);
        br.close();
    }
}