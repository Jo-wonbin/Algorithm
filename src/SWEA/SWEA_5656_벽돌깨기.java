package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class rock {
	int x, y, size;

	rock(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}

public class SWEA_5656_벽돌깨기 {
	static int down, n, m, result;
	static int map[][];
	static int copy[][];
	static int rock[];
	static Queue<rock> q = new LinkedList<>();
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean type = false;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		int count = 0;
		while (count < num) {
			st = new StringTokenizer(br.readLine(), " ");
			down = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			copy = new int[n][m];
			rock = new int[down];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = Integer.MAX_VALUE;
			dfs(down, 0);
			bw.write("#" + (count + 1) + " " + result + "\n");
			count++;
		}
		br.close();
		bw.flush();
		bw.close();
	}
	static void copyMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	static void bfs(int x) {
		for (int i = 0; i < n; i++) {
			if (copy[i][x] != 0) {
				q.add(new rock(i, x, copy[i][x]));
				break;
			}
		}
		boolean check[][] = new boolean[n][m];
		while (!q.isEmpty()) {
			rock now = q.poll();

			if (now.size == 1) {
				copy[now.x][now.y] = 0;
				continue;
			} else {
				copy[now.x][now.y] = 0;
				check[now.x][now.y] = true;
			}

			for (int h = 0; h < 4; h++) {// size 2�̻�
				for (int i = 1; i < now.size; i++) {
					int nx = now.x + (i * dx[h]);
					int ny = now.y + (i * dy[h]);

					if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
						continue;
					if (check[nx][ny])
						continue;
					if (copy[nx][ny] == 0)
						continue;

					q.add(new rock(nx, ny, copy[nx][ny]));
					copy[nx][ny] = 0;
					check[nx][ny] = true;
				}
			}
		}

		int aa = 0;
		for (int j = 0; j < m; j++) {
			int cnt = 0;
			int list[] = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				if (copy[i][j] != 0) {
					list[cnt] = copy[i][j];
					cnt++;
					aa++;
				}
			}
			cnt = 0;
			for (int i = n - 1; i >= 0; i--) {
				copy[i][j] = list[cnt];
				cnt++;
			}
		}

		if (type) {
			result = Math.min(result, aa);
		}
	}

	static void dfs(int down, int cnt) {
		if (cnt == down) {
			copyMap();
			for (int i = 0; i < down; i++) {
				if (i == down - 1)
					type = true;
				else
					type = false;
				bfs(rock[i]);
			}
			return;
		}

		for (int i = 0; i < m; i++) {
			rock[cnt] = i;
			dfs(down, cnt + 1);
		}
	}
}
