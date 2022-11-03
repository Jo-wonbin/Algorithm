package BOJ.BOJweek6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {
	int x, y, count;

	point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	point(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class BOJ_2573 {

	static int n, m;
	static int map[][];
	static boolean check[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	static ArrayList<point> al = new ArrayList<>();

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
		int tcnt = 0;
		while (true) {
			check = new boolean[n][m];
			int cnt = 0;// ������ ��
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!check[i][j] && map[i][j] != 0) {
						bfs(i, j);
						cnt++;
					}
				}
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j]+ " ");
//				}
//				System.out.println();
//			}
//			System.out.println("---------------");

			if (cnt >= 2) {
				bw.write(tcnt + "");
				break;
			} else if (cnt == 0) {
				bw.write("0");
				break;
			}
			remove();
			tcnt++;
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void remove() {
		for (int i = 0; i < al.size(); i++) {
			int x = al.get(i).x;
			int y = al.get(i).y;
			int z = al.get(i).count;

			if (map[x][y] >= z) {
				map[x][y] -= z;
			} else {
				map[x][y] = 0;
			}
		}
		al.clear();
	}

	static void bfs(int x, int y) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(x, y));
		check[x][y] = true;

		while (!q.isEmpty()) {
			point now = q.poll();
			int count = 0;
			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (check[nx][ny])
					continue;
				if (map[nx][ny] == 0) {
					count++;
					continue;
				}

				check[nx][ny] = true;
				q.add(new point(nx, ny));
			}
			al.add(new point(now.x, now.y, count));
		}
	}
}
