package BOJ.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1941_소문난칠공주 {

    static char[][] student = new char[5][5];
    static int answer;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int x[];
    static int y[];
    static int arr[];
    static boolean check[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        x = new int[25];
        y = new int[25];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for (int j = 0; j < 5; j++) {
                x[count] = i;
                y[count] = j;
                student[i][j] = temp.charAt(j);
                count++;
            }
        }
        arr = new int[7];
        check = new boolean[25];
        answer = 0;

        Combination(0, 0);

        System.out.println(answer);

        br.close();
    }

    static void Combination(int cnt, int num) {

        if (cnt == 7) {

            if (bfs()) {
                answer++;
            }

            return;
        }

        for (int i = num; i < 25; i++) {
            if (check[i])
                continue;
            arr[cnt] = i;
            check[i] = true;
            Combination(cnt + 1, i + 1);
            check[i] = false;
        }
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(arr[0]);

        boolean visited[] = new boolean[7];

        int length = 1;
        int countS = 0;
        visited[0] = true;

        if (student[x[arr[0]]][y[arr[0]]] == 'S')
            countS++;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int h = 0; h < 4; h++) {
                int rx = dx[h] + x[now];
                int ry = dy[h] + y[now];

                for (int j = 1; j < 7; j++) {
                    if (rx < 0 || ry < 0 || rx > 4 || ry > 4)
                        continue;
                    if (visited[j])
                        continue;

                    if (rx != x[arr[j]])
                        continue;
                    if (ry != y[arr[j]])
                        continue;

                    if (student[rx][ry] == 'S')
                        countS++;
                    visited[j] = true;
                    q.add(arr[j]);
                    length++;
                }

            }

        }
        if (length == 7) {

            if (countS < 4)
                return false;

            return true;
        }
        return false;
    }
}
