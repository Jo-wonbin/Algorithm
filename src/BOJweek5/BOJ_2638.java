package BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class p {
	int x, y;

	p(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2638 {

	static int n, m;
	static int map[][];
	static boolean check[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };
	static ArrayList<p> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		while (true) {
			check = new boolean[n][m];
			air();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						cheese(i, j);
					}
				}
			}
			if (al.size() != 0) {
				int c = al.size();
				for (int i = 0; i < c; i++) {
					map[al.get(i).x][al.get(i).y] = 0;
				}
				al.clear();
				result += 1;
			} else {
				break;
			}
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void air() {
		Queue<p> q = new LinkedList<>();
		q.add(new p(0, 0));

		while (!q.isEmpty()) {
			p now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (check[nx][ny])
					continue;
				if (map[nx][ny] == 1)
					continue;

				check[nx][ny] = true;
				q.add(new p(nx, ny));
			}
		}
	}

	static void cheese(int x, int y) {
		Queue<p> q = new LinkedList<>();

		q.add(new p(x, y));
		int cnt = 0;
		while (!q.isEmpty()) {

			p now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (map[nx][ny] == 1)
					continue;
				if (map[nx][ny] == 0 && !check[nx][ny])
					continue;

				cnt += 1;
			}
		}
		if (cnt >= 2) {
			al.add(new p(x, y));
		}
	}
}
