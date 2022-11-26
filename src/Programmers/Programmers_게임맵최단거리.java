package Programmers;

import java.util.*;

public class Programmers_게임맵최단거리 {

    class Solution {

        class Point {
            int x, y, cnt;

            Point(int x, int y, int cnt) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        boolean visited[][];

        public int solution(int[][] maps) {
            int answer = 0;

            int n = maps.length;
            int m = maps[0].length;
            visited = new boolean[n][m];

            answer = find(maps, n, m);

            return answer;
        }

        public int find(int map[][], int n, int m) {
            Queue<Point> q = new LinkedList<>();

            q.add(new Point(0, 0, 1));
            visited[0][0] = true;

            while (!q.isEmpty()) {

                Point now = q.poll();

                if (now.x == n - 1 && now.y == m - 1) {
                    return now.cnt;
                }

                for (int h = 0; h < 4; h++) {
                    int nx = now.x + dx[h];
                    int ny = now.y + dy[h];

                    if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
                        continue;

                    if (visited[nx][ny])
                        continue;

                    if (map[nx][ny] == 0)
                        continue;

                    q.add(new Point(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }

            }

            return -1;
        }
    }
}
