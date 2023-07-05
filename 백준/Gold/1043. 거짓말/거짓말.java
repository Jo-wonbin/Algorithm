import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
    static ArrayList<Integer> truth = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Integer> people[];
    static int N, M, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        for (int i = 0; i < max; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }
        people = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int times = Integer.parseInt(st.nextToken());
            ArrayList<Integer> tp = new ArrayList<>();

            for (int j = 0; j < times; j++) {
                int temp = Integer.parseInt(st.nextToken());
                tp.add(temp);
                people[temp].add(i);
            }
            parties.add(tp);
        }

        visited = new boolean[M + 1];
        result = 0;

        bfs();

        System.out.println(result);

        br.close();
    }

    public static void bfs() {
        boolean[] numChk = new boolean[N + 1];
        for (int i = 0; i < truth.size(); i++) {
            q.add(truth.get(i));

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int j = 0; j < people[now].size(); j++) {
                    int partyNum = people[now].get(j);
                    if (visited[partyNum])
                        continue;
                    visited[partyNum] = true;
                    for (int z = 0; z < parties.get(partyNum - 1).size(); z++) {
                        q.add(parties.get(partyNum - 1).get(z));
                    }
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            if (!visited[i])
                result++;
        }
    }
}