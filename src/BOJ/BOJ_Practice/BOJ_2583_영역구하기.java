package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pp {
	int x, y;

	pp(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2583_영역구하기 {
	static int n, m, k, result;
	static int map[][];
	static boolean check[][];
	static Queue<pp> q = new LinkedList<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new boolean[n][m];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken()) - 1;
			int nx = Integer.parseInt(st.nextToken()) - 1;

			for (int h = x; h <= nx; h++) {
				for (int z = y; z <= ny; z++) {
					map[h][z] = 1;
				}
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!check[i][j] && map[i][j] == 0) {
					check[i][j] = true;
					bfs(i, j);
					al.add(result);
					cnt++;
				}
			}
		}

		bw.write(cnt + "\n");
		Collections.sort(al);
		for (int c : al)
			bw.write(c + " ");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y) {
		q.add(new pp(x, y));
		result = 1;
		while (!q.isEmpty()) {
			pp now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (check[nx][ny] || map[nx][ny] == 1)
					continue;

				check[nx][ny] = true;
				q.add(new pp(nx, ny));
				result++;
			}
		}
	}
}
