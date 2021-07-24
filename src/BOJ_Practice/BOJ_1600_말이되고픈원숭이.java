package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class mk {
	int x, y, kcnt, size;

	mk(int x, int y, int kcnt, int size) {
		this.x = x;
		this.y = y;
		this.kcnt = kcnt;
		this.size = size;
	}
}

public class BOJ_1600_말이되고픈원숭이 {

	static int n, m, k, result = -1;
	static int map[][];
	static boolean check[][][];
	static int dx[] = { 0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dy[] = { -1, 1, 0, 0, 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new boolean[k + 1][n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<mk> q = new LinkedList<>();
		q.add(new mk(0, 0, k, 0));
		check[k][0][0] = true;

		while (!q.isEmpty()) {
			mk now = q.poll();

			if (now.x == n - 1 && now.y == m - 1) {
				result = now.size;
				return;
			}

			for (int h = 0; h < 12; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];
				int nk = now.kcnt;

				if (h >= 4) {
					if (nk == 0)
						break;
					else
						nk--;
				}

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (map[nx][ny] == 1)
					continue;
				if (check[nk][nx][ny])
					continue;

				check[nk][nx][ny] = true;
				q.add(new mk(nx, ny, nk, now.size + 1));
			}
		}
	}
}
