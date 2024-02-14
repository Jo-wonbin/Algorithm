import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Times implements Comparable<Times> {
        int start, end;

        Times(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Times o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Times> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Times(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int result = 0;
        int lastEndTime = 0;

        while (!pq.isEmpty()) {
            Times now = pq.poll();
            if (lastEndTime <= now.start) {
                result++;
                lastEndTime = now.end;
            }
        }
        System.out.println(result);
        br.close();
    }
}