package BOJ.BOJweek8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {

    static class Floor {
        int floor, time;

        Floor(int floor, int time) {
            this.floor = floor;
            this.time = time;
        }
    }

    static int F, S, G, U, D;
    static boolean check[];
    static int result;
    static Queue<Floor> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;

        q.add(new Floor(S, 0));
        check = new boolean[F + 1];
        check[S] = true;
        find();

        if (result != Integer.MAX_VALUE) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }

        br.close();
    }

    static void find() {

        while (!q.isEmpty()) {

            Floor now = q.poll();

            if (now.floor == G) {
                result = Math.min(now.time, result);
                continue;
            }

            int up = now.floor + U;
            int down = now.floor - D;

            if (up <= F && !check[up]) {
                q.add(new Floor(up, now.time + 1));
                check[up] = true;
            }
            if (down >= 1 && !check[down]) {
                q.add(new Floor(down, now.time + 1));
                check[down] = true;
            }

        }

    }
}
