package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pair {
	int x;
	int y;
	int cnt;

	pair(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class BOJ_7562 {

	static int num, result;
	static int map[][];
	static boolean check[][];
	static int dx[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int cnt = 0;
		while (cnt < n) {
			st = new StringTokenizer(br.readLine(), " ");
			num = Integer.parseInt(st.nextToken());

			map = new int[num][num];
			check = new boolean[num][num];
			int c = 0, d = 0;
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (i == 0) {
					map[a][b] = 1;
					c = a;
					d = b;
				} else if (i == 1) {
					map[a][b] = 2;
				}
			}
			result = Integer.MIN_VALUE;
			bfs(c, d);
			bw.write(result + "\n");

			cnt++;
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int x, int y) {
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(x, y, 0));
		check[x][y] = true;

		while (!q.isEmpty()) {
			pair now = q.poll();

			if (map[now.x][now.y] == 2) {
				result = now.cnt;
				return;
			}

			for (int h = 0; h < 8; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > num - 1 || ny > num - 1)
					continue;
				if (check[nx][ny])
					continue;

				check[nx][ny] = true;
				q.add(new pair(nx, ny, now.cnt + 1));
			}
		}
	}
}
