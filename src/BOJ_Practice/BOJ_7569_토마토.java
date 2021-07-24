package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tmt {
	int x, y, z;

	tmt(int z, int x, int y) {
		this.z = z;
		this.x = x;
		this.y = y;
	}
}

public class BOJ_7569_토마토 {
	static int n, m, z, result;
	static int map[][][];
	static int check[][][];
	static Queue<tmt> q = new LinkedList<>();
	static int dx[] = { 0, 0, -1, 1, 0, 0 };
	static int dy[] = { -1, 1, 0, 0, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		z = Integer.parseInt(st.nextToken());

		map = new int[z][n][m];
		check = new int[z][n][m];

		for (int i = 0; i < z; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						q.add(new tmt(i, j, k));
						check[i][j][k] = 0;
					} else {
						check[i][j][k] = -1;
					}
				}
			}
		}

		result = 0;

		bfs();

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			tmt now = q.poll();

			for (int h = 0; h < 6; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];
				int nz = now.z + dz[h];

				if (nx < 0 || ny < 0 || nz < 0 || nx > n - 1 || ny > m - 1 || nz > z - 1)
					continue;
				if (map[nz][nx][ny] == -1 || map[nz][nx][ny] == 1)
					continue;
				if (check[nz][nx][ny] > -1)
					continue;

				q.add(new tmt(nz, nx, ny));
				check[nz][nx][ny] = check[now.z][now.x][now.y] + 1;
				map[nz][nx][ny] = 1;
			}
		}
		Loop1: for (int i = 0; i < z; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) {
						result = -1;
						break Loop1;
					}

					result = Math.max(result, check[i][j][k]);
				}
			}
		}
	}
}
