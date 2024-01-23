import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int snow[] = new int[N];

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while (pq.size() > 1) {

            int temp1 = pq.poll();
            int temp2 = pq.poll();
            temp1--;
            if (temp1 > 0)
                pq.add(temp1);
            temp2--;
            if (temp2 > 0) {
                pq.add(temp2);
            }
            result++;
            if (result > 1440) {
                System.out.println("-1");
                return;
            }
        }

        if (pq.size() > 0)
            result += pq.poll();

        if (result > 1440) {
            System.out.println("-1");
        } else
            System.out.println(result);

        br.close();
    }


}