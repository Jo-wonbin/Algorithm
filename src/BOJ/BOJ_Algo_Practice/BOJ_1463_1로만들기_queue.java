package BOJ.BOJ_Algo_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1463_1로만들기_queue {

    static int result;

    static class Count {
        int x, count;

        Count(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        Queue<Count> q = new LinkedList<>();

        result = Integer.MAX_VALUE;

        find(X);

        System.out.println(result);

        br.close();
    }

    static void find(int X) {
        Queue<Count> q = new LinkedList<>();

        q.add(new Count(X, 0));

        while (!q.isEmpty()) {
            Count temp = q.poll();

            if (temp.x < 1) {
                continue;
            }

            if (temp.x == 1) {
                result = Math.min(result, temp.count);
                break;
            }
            if (temp.x % 3 == 0)
                q.add(new Count(temp.x / 3, temp.count + 1));

            if (temp.x % 2 == 0)
                q.add(new Count(temp.x / 2, temp.count + 1));

            q.add(new Count(temp.x - 1, temp.count + 1));
        }

    }
}
