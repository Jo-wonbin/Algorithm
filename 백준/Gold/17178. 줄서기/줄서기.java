import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Ticket implements Comparable<Ticket> {
        char alpha;
        int num;

        Ticket(char alpha, int num) {
            this.alpha = alpha;
            this.num = num;
        }

        @Override
        public int compareTo(Ticket o) {
            if (this.alpha < o.alpha) {
                return this.alpha - o.alpha;
            } else if (this.alpha == o.alpha) {
                return this.num - o.num;
            }
            return this.alpha - o.alpha;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Ticket> people = new LinkedList<>();
        Stack<Ticket> wait = new Stack<>();
        PriorityQueue<Ticket> pq = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                String[] temp = st.nextToken().split("-");
                char alpha = temp[0].charAt(0);
                int num = Integer.parseInt(temp[1]);

                people.add(new Ticket(alpha, num));
                pq.add(new Ticket(alpha, num));
            }
        }

        while (!people.isEmpty()) {
            if (people.peek().alpha == pq.peek().alpha && people.peek().num == pq.peek().num) {
                Ticket temp = pq.poll();
                people.poll();
            } else if (!wait.isEmpty() && wait.peek().alpha == pq.peek().alpha && wait.peek().num == pq.peek().num) {
                Ticket temp = pq.poll();
                wait.pop();
            } else {
                wait.push(people.poll());
            }
        }
        boolean flag = true;
        while (!wait.isEmpty()) {
            if (wait.peek().alpha == pq.peek().alpha && wait.peek().num == pq.peek().num) {
                Ticket temp = wait.pop();
                pq.poll();

            } else {
                flag = false;
                break;
            }
        }

        if (flag)
            System.out.println("GOOD");
        else
            System.out.println("BAD");

        br.close();
    }

}