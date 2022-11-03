package BOJ.BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14500 {
	static int n, m;
	static int map[][];
	static int result = Integer.MIN_VALUE;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { -1, 1, 0, 0 };
	static boolean check[][];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				check[i][j] = true;
				dfs(i, j, map[i][j], 1);
				check[i][j] = false;
				find(i, j);
			}
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void find(int x, int y) {
		if (x >= 0 && x + 1 <= n - 1 && y >= 0 && y + 2 <= m - 1) {
			int num = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1];
			result = Math.max(result, num);
		}

		if (x >= 0 && x + 2 <= n - 1 && y >= 0 && y + 1 <= m - 1) {
			int num = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1];
			result = Math.max(result, num);
		}

		if (x - 1 >= 0 && x <= n - 1 && y >= 0 && y + 2 <= m - 1) {
			int num = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1];
			result = Math.max(result, num);
		}

		if (x - 1 >= 0 && x + 1 <= n - 1 && y >= 0 && y + 1 <= m - 1) {
			int num = map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x + 1][y + 1];
			result = Math.max(result, num);
		}
	}

	static void dfs(int x, int y, int num, int cnt) {
		if (cnt >= 4) {
			if (result < 0) {
				result = num;
			} else {
				result = Math.max(result, num);
			}
			return;
		}

		for (int h = 0; h < 4; h++) {
			int nx = x + dx[h];
			int ny = y + dy[h];

			if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
				continue;
			if (!check[nx][ny]) {
				check[nx][ny] = true;
				dfs(nx, ny, num + map[nx][ny], cnt + 1);
				check[nx][ny] = false;
			}
		}
	}
}
