package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {

	static Queue<location> q2 = new LinkedList<location>();
	static Queue<location> q1 = new LinkedList<location>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static char[][] map;
	static int[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		check = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(check[i], -1);
		}

		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = a.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '*') {
					q1.add(new location(i, j));
				}
				if (map[i][j] == 'S') {
					q2.add(new location(i, j));
					check[i][j] = 0;
				}

			}
		}

		bfs(map);

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(char[][] map) throws IOException {

		while (true) {

			int c = q1.size();
			for (int i = 0; i < c; i++) {
				location now1 = q1.poll();

				for (int h = 0; h < 4; h++) {
					int nx1 = now1.x + dx[h];
					int ny1 = now1.y + dy[h];

					if (nx1 < 0 || ny1 < 0 || nx1 > n - 1 || ny1 > m - 1)
						continue;
					if (map[nx1][ny1] == 'D' || map[nx1][ny1] == 'X' || map[nx1][ny1] == '*')
						continue;

					q1.offer(new location(nx1, ny1));
					map[nx1][ny1] = '*';
				}
			}
			
			if (q2.size() == 0) {

				bw.write("KAKTUS" + "");
				return;
			}

			int d = q2.size();
			for (int i = 0; i < d; i++) {

				location now = q2.poll();

				for (int h = 0; h < 4; h++) {
					int nx = now.x + dx[h];
					int ny = now.y + dy[h];

					if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
						continue;
					if (map[nx][ny] == '*' || map[nx][ny] == 'X')
						continue;
					if (check[nx][ny] > 0)
						continue;

					q2.offer(new location(nx, ny));
					check[nx][ny] = check[now.x][now.y] + 1;

					if (map[nx][ny] == 'D') {
						bw.write(check[nx][ny] + "");
						return;
					}
				}
			}
		}
	}
}

class location {
	int x;
	int y;
	
	location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
