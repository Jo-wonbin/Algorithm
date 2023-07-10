import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Fireball {
        int x, y, m, dir, speed;

        Fireball(int x, int y, int m, int speed, int dir) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.speed = speed;
            this.dir = dir;
        }
    }

    static int N, M, K;
    static int[][] map;
    static int dx[];
    static int dy[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Fireball> fireballs = new ArrayList<>();
        Queue<Fireball> q = new LinkedList<>();
        map = new int[N][N];
        dx = new int[]{N - 1, N - 1, 0, 1, 1, 1, 0, N - 1};
        dy = new int[]{0, 1, 1, 1, 0, N - 1, N - 1, N - 1};
        for (int z = 0; z < M; z++) {
            st = new StringTokenizer(br.readLine());
            fireballs.add(new Fireball(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int z = 0; z < K; z++) {
            int visited[][] = new int[N][N];
            for (int i = 0; i < fireballs.size(); i++) {
                Fireball temp = fireballs.get(i);
                int nx = (temp.x + (dx[temp.dir] * temp.speed)) % N;
                int ny = (temp.y + (dy[temp.dir] * temp.speed)) % N;

                visited[nx][ny]++;
                fireballs.get(i).x = nx;
                fireballs.get(i).y = ny;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] >= 2) {
                        int m = 0;
                        int s = 0;
                        int dir = -1;
                        boolean flag = true;
                        for (int h = 0; h < fireballs.size(); h++) {
                            Fireball temp = fireballs.get(h);
                            if (temp.x == i && temp.y == j) {
                                m += temp.m;
                                s += temp.speed;
                                if (dir == -1) {
                                    dir = temp.dir % 2;
                                } else if (dir != temp.dir % 2) {
                                    flag = false;
                                }
                                fireballs.remove(h--);
                            }
                        }
                        m /= 5;
                        if (m == 0)
                            continue;
                        s /= visited[i][j];
                        int start = 0;
                        if (!flag) {
                            start = 1;
                        }
                        for (int h = start; h < 8; h += 2) {
                            q.add(new Fireball(i, j, m, s, h));
                        }
                    }
                }
            }

            for (int i = 0; i < fireballs.size(); i++) {
                if (visited[fireballs.get(i).x][fireballs.get(i).y] >= 2) {
                    fireballs.remove(i);
                    i--;
                }
            }
            while (!q.isEmpty()) {
                fireballs.add(q.poll());
            }
        }
        int result = 0;
        for (Fireball temp : fireballs) {
            result += temp.m;
        }

        System.out.println(result);

        br.close();
    }

}