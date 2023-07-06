import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> q = new LinkedList<>();
        int nowWeight = 0;

        int result = 0;
        while (!trucks.isEmpty()) {
            if (trucks.peek() + nowWeight <= L) {
                int temp = trucks.poll();
                q.add(temp);
                nowWeight += temp;
            } else {
                q.add(0);
            }

            if (q.size() >= W) {
                nowWeight -= q.poll();
            }

            result++;
        }
        result += W;

        System.out.println(result);

        br.close();
    }

}