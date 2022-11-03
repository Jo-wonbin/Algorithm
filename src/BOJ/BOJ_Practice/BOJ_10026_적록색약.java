package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class rgb {
	int x, y;

	rgb(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_10026_적록색약 {
	static int n, result;
	static int map[][];
	static boolean check[][];
	static boolean chk[][];
	static Queue<rgb> q = new LinkedList<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		check = new boolean[n][n];
		chk = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < n; j++) {
				if (a.substring(j, j + 1).equals("R")) {
					map[i][j] = 1;
				} else if (a.substring(j, j + 1).equals("G")) {
					map[i][j] = 2;
				}
			}
		}
		int count = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					check[i][j] = true;
					bfs(i, j, check, false);
					count++;
				}
				if (!chk[i][j]) {
					chk[i][j] = true;
					bfs(i, j, chk, true);
					cnt++;
				}
			}
		}

		bw.write(count + " " + cnt + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y, boolean arr[][], boolean type) {
		q.add(new rgb(x, y));

		while (!q.isEmpty()) {
			rgb now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
					continue;
				if (!type) {
					if (map[nx][ny] != map[now.x][now.y])
						continue;
				} else {
					if (map[now.x][now.y] == 0) {
						if (map[nx][ny] != 0)
							continue;
					} else {
						if (map[nx][ny] == 0)
							continue;
					}
				}
				if (arr[nx][ny])
					continue;

				arr[nx][ny] = true;
				q.add(new rgb(nx, ny));
			}
		}
	}
}
