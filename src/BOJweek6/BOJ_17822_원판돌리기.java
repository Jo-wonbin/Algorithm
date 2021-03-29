package BOJweek6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class rol {
	int x, y;

	rol(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_17822_원판돌리기 {
	static int n, m, k, result = 0;
	static int map[][];
	static boolean check[][];
	static Queue<rol> q = new LinkedList<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static boolean ans;
	static boolean type;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			roll(x, d, num);

		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				result += map[i][j];
			}
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void roll(int x, int d, int num) {
		int cnt = 1;
		int tp = x;
		while (tp <= n) {
			if (d == 0) {
				for (int j = 1; j <= num; j++) {
					int temp = map[tp][m];
					for (int i = m; i >= 2; i--) {
						map[tp][i] = map[tp][i - 1];
					}
					map[tp][1] = temp;
				}
			} else {
				for (int j = 1; j <= num; j++) {
					int temp = map[tp][1];
					for (int i = 1; i <= m - 1; i++) {
						map[tp][i] = map[tp][i + 1];
					}
					map[tp][m] = temp;
				}
			}
			cnt++;
			tp = x * cnt;
		}
		check = new boolean[n + 1][m + 1];
		ans = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 0)
					continue;
				if (!check[i][j]) {
					type = false;
					bfs(i, j);
					if (type) {
						check[i][j] = true;
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (check[i][j])
					map[i][j] = 0;
			}
		}

		if (!ans) {
			double sum = 0;
			int count = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (map[i][j] != 0) {
						sum += map[i][j];
						count++;
					}
				}
			}
			sum = sum / count;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					if (map[i][j] == 0)
						continue;

					if ((double) map[i][j] > sum) {
						map[i][j] -= 1;
					} else if ((double) map[i][j] < sum) {
						map[i][j] += 1;
					}
				}
			}
		}
		q.clear();
	}

	static void bfs(int x, int y) {
		q.add(new rol(x, y));

		while (!q.isEmpty()) {
			rol now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (h == 0 && ny == 0) {
					ny = m;
				}
				if (h == 1 && ny == m + 1) {
					ny = 1;
				}
				if (nx < 1 || nx > n || ny < 1 || ny > m)
					continue;
				if (map[nx][ny] == 0 || map[nx][ny] != map[now.x][now.y])
					continue;
				if (check[nx][ny])
					continue;

				check[nx][ny] = true;
				q.add(new rol(nx, ny));
				type = true;
				ans = true;

			}
		}
	}
}
