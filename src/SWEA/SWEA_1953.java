package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {
	int x, y, time;

	point(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class SWEA_1953 {

	static int n, m, r, c, l;
	static int map[][];
	static int check[][];
	static int cnt;
	static int dx[] = { -1, 0, 1, 0 }; // »ó¿ìÇÏÁÂ
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		int num = Integer.parseInt(a);

		int count = 1;
		while (count <= num) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			check = new int[n][m];
			cnt = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (check[i][j] != 0 && check[i][j] <= l) {
						cnt += 1;
					}
				}
			}
			bw.write("#" + count + " " + cnt + "\n");

			count += 1;
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(r, c, 1));
		check[r][c] = 1;
		while (!q.isEmpty()) {
			point now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (check[nx][ny] > 0)
					continue;
				if (map[nx][ny] == 0)
					continue;

				if (h == 0 && (map[now.x][now.y] == 3 || map[now.x][now.y] == 5 || map[now.x][now.y] == 6))
					continue;
				if (h == 1 && (map[now.x][now.y] == 2 || map[now.x][now.y] == 6 || map[now.x][now.y] == 7))
					continue;
				if (h == 2 && (map[now.x][now.y] == 3 || map[now.x][now.y] == 4 || map[now.x][now.y] == 7))
					continue;
				if (h == 3 && (map[now.x][now.y] == 2 || map[now.x][now.y] == 4 || map[now.x][now.y] == 5))
					continue;

				if (map[now.x][now.y] == 1) {
					if (h == 0) {
						if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)
							continue;
					} else if (h == 1) {
						if (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)
							continue;
					}else if (h == 2) {
						if (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)
							continue;
					}else {
						if (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)
							continue;
					}
				}else if(map[now.x][now.y] == 2) {
					if(h==0) {
						if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)
							continue;
					}else if (h == 2) {
						if (map[nx][ny] == 3 || map[nx][ny] == 5 || map[nx][ny] == 6)
							continue;
					}
				}else if(map[now.x][now.y] == 3) {
					if(h==1) {
						if (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)
							continue;
					}else if (h == 3) {
						if (map[nx][ny] == 2 || map[nx][ny] == 6 || map[nx][ny] == 7)
							continue;
					}
				}else if(map[now.x][now.y] == 4) {
					if(h==0) {
						if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)
							continue;
					}else if (h == 1) {
						if (map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 5)
							continue;
					}
				}else if(map[now.x][now.y] == 5) {
					if(h==1) {
						if (map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 4)
							continue;
					}else if (h == 2) {
						if (map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 5)
							continue;
					}
				}else if(map[now.x][now.y] == 6) {
					if(h==2) {
						if (map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 5)
							continue;
					}else if (h == 3) {
						if (map[nx][ny] == 2 || map[nx][ny] == 7 || map[nx][ny] == 6)
							continue;
					}
				}else if(map[now.x][now.y] == 7) {
					if(h==0) {
						if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 7)
							continue;
					}else if (h == 3) {
						if (map[nx][ny] == 2 || map[nx][ny] == 7 || map[nx][ny] == 6)
							continue;
					}
				}

				q.add(new point(nx, ny, now.time + 1));
				check[nx][ny] = now.time + 1;
			}

		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(check[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------");

	}

}
