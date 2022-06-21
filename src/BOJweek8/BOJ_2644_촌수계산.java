package BOJweek8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

    static int peopleNum;
    static boolean relation[][];
    static boolean check[];
    static int person1;
    static int person2;
    static int result;

    static class Bro {
        int p;
        int time;

        Bro(int p, int time) {
            this.p = p;
            this.time = time;
        }
    }

    static Queue<Bro> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        peopleNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());

        relation = new boolean[peopleNum + 1][peopleNum + 1];
        check = new boolean[peopleNum + 1];

        st = new StringTokenizer(br.readLine());
        int times = Integer.parseInt(st.nextToken());
        for (int i = 0; i < times; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = true;
            relation[b][a] = true;
        }
        result = -1;
        q.add(new Bro(person1, 0));
        check[person1] = true;
        find();

        System.out.println(result);

        br.close();
    }

    static void find() {

        while (!q.isEmpty()) {
            Bro now = q.poll();

            if (now.p == person2) {
                result = now.time;
                break;
            }

            for (int i = 1; i <= peopleNum; i++) {
                if (check[i])
                    continue;
                if (!relation[now.p][i])
                    continue;
                q.add(new Bro(i, now.time + 1));
                check[i] = true;
            }
        }

    }
}
