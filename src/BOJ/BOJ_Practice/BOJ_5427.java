package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {
	int x, y, bcnt;

	point(int x, int y, int bcnt) {
		this.x = x;
		this.y = y;
		this.bcnt = bcnt;
	}

	point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class BOJ_5427 {

	static int x, y, result, bc;
	static boolean chk;
	static int map[][];
	static int check[][];
	static Queue<point> q = new LinkedList<>();
	static Queue<point> al = new LinkedList<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		while (num-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			map = new int[x][y];
			check = new int[x][y];

			bc = 0;
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				for (int j = 0; j < y; j++) {
					if (a.substring(j, j + 1).equals(".")) {
						map[i][j] = 0;
					} else if (a.substring(j, j + 1).equals("#")) {// ��
						map[i][j] = 2;
					} else if (a.substring(j, j + 1).equals("@")) {// ���
						map[i][j] = 1;
						q.add(new point(i, j, 0));
						check[i][j] = 1;
					} else {
						map[i][j] = 3;
						al.add(new point(i, j));
						bc++;
					}
				}
			}

			result = 0;
			bfs();

			if (chk) {
				bw.write(result + "\n");
			} else {
				bw.write("IMPOSSIBLE\n");
			}
			q.clear();
			al.clear();
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void burn(int cnt) {
		bc = 0;
		while (cnt-- > 0) {
			point now = al.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > x - 1 || ny > y - 1)
					continue;
				if (map[nx][ny] == 2 || map[nx][ny] == 3)
					continue;

				map[nx][ny] = 3;
				al.add(new point(nx, ny));
				bc++;
			}
		}
	}

	static void bfs() {
		chk = false;
		int bcnt = 0;
		if (!al.isEmpty()) {
			burn(bc);
		}

		while (!q.isEmpty()) {
			point now = q.poll();

			if (now.x == 0 || now.y == 0 || now.x == x - 1 || now.y == y - 1) {
				result = check[now.x][now.y];
				chk = true;
				return;
			}

			if (now.bcnt > bcnt && !al.isEmpty()) {
				burn(bc);
				bcnt++;
			}

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > x - 1 || ny > y - 1)
					continue;
				if (map[nx][ny] == 3 || map[nx][ny] == 2)
					continue;
				if (check[nx][ny] > 0)
					continue;

				check[nx][ny] = check[now.x][now.y] + 1;
				q.add(new point(nx, ny, now.bcnt + 1));
			}
		}
	}
}
