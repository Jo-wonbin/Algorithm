package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class area {
	int x, y;

	area(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2468_안전영역 {
	static int n, result;
	static int map[][];
	static boolean check[][];
	static Queue<area> q = new LinkedList<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		int max = 0;
		int min = 101;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		result = 1;
		while (max >= min) {
			int cnt = 0;
			check = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!check[i][j] && max < map[i][j]) {
						check[i][j] = true;
						bfs(i, j, max);
						cnt++;
					}
				}
			}
			max--;
			result = Math.max(result, cnt);
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y, int max) {
		q.add(new area(x, y));
		while (!q.isEmpty()) {
			area now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
					continue;
				if (map[nx][ny] <= max)
					continue;
				if (check[nx][ny])
					continue;

				check[nx][ny] = true;
				q.add(new area(nx, ny));
			}
		}
	}
}
