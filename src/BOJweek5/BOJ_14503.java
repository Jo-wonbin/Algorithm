package BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {
	int x, y, z;

	point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class BOJ_14503 {

	static int n, m;
	static int map[][];
	static boolean check[][];
	static int dx[] = { 0, 1, 0, -1, 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if (c == 3) { // 馆矫拌规氢栏肺 官层淋
			c = 1;
		} else if (c == 1) {
			c = 3;
		}

		map = new int[n][m];
		check = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(a, b, c);

//		for (int i = 0; i <= n - 1; i++) {
//			for (int j = 0; j <= m - 1; j++) {
//				if (check[i][j])
//					System.out.print("1 ");
//				else {
//					System.out.print("0 ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i <= n - 1; i++) {
//			for (int j = 0; j <= m - 1; j++) {
//				if (i == a && j == b) {
//					bw.write("2" + " ");
//				} else
//					bw.write(map[i][j] + " ");
//			}
//			bw.write("\n");
//		}

		int cnt = 0;
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (check[i][j])
					cnt += 1;
			}
		}

		bw.write(cnt + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int a, int b, int c) {
		Queue<point> q = new LinkedList<>();

		q.add(new point(a, b, c));
		check[a][b] = true;// 没家
		//int idx = 1;
		Loop1: while (!q.isEmpty()) {
			point now = q.poll();

			if (now.z == 0 || now.z == 4) { // 0
				for (int h = 0; h < 4; h++) {
					int nx = now.x + dx[h];// 沥规氢
					int ny = now.y + dy[h];
					int xxx = now.x - dx[h];// 第肺
					int yyy = now.y - dy[h];

					if (nx >= 0 && ny >= 0 && nx <= n - 1 && ny <= m - 1) {

						if (map[nx][ny] == 0 && !check[nx][ny]) { // a
							check[nx][ny] = true;// 没家
							q.add(new point(nx, ny, h + 1));
							break;
						} else if (h == 3 && (check[nx][ny] || map[nx][ny] == 1)) { // 4规氢 促 没家
							if (map[xxx][yyy] == 0) {
								q.add(new point(xxx, yyy, now.z));
								break;
							} else {
								break Loop1;
							}
						}

					}

				}
			} else if (now.z == 1 || now.z == 5) {

				for (int h = 1; h < 5; h++) {
					int nx = now.x + dx[h];
					int ny = now.y + dy[h];
					int xxx = now.x - dx[h];// 第肺
					int yyy = now.y - dy[h];

					if (nx >= 0 && ny >= 0 && nx <= n - 1 && ny <= m - 1) {

						if (map[nx][ny] == 0 && !check[nx][ny]) { // a
							check[nx][ny] = true;// 没家
							q.add(new point(nx, ny, h + 1));
							break;
						} else if (h == 4 && (check[nx][ny] || map[nx][ny] == 1)) { // 4规氢 促 没家
							if (map[xxx][yyy] == 0) {
								q.add(new point(xxx, yyy, now.z));
								break;
							} else {
								break Loop1;
							}
						}

					}
				}
			} else if (now.z == 2 || now.z == 6) {

				for (int h = 2; h < 6; h++) {
					int nx = now.x + dx[h];
					int ny = now.y + dy[h];
					int xxx = now.x - dx[h];// 第肺
					int yyy = now.y - dy[h];

					if (nx >= 0 && ny >= 0 && nx <= n - 1 && ny <= m - 1) {

						if (map[nx][ny] == 0 && !check[nx][ny]) { // a
							check[nx][ny] = true;// 没家
							q.add(new point(nx, ny, h + 1));
							break;
						} else if (h == 5 && (check[nx][ny] || map[nx][ny] == 1)) { // 4规氢 促 没家
							if (map[xxx][yyy] == 0) {
								q.add(new point(xxx, yyy, now.z));
								break;
							} else {
								break Loop1;
							}
						}

					}
				}
			} else if (now.z == 3 || now.z == 7) {

				for (int h = 3; h < 7; h++) {
					int nx = now.x + dx[h];
					int ny = now.y + dy[h];
					int xxx = now.x - dx[h];// 第肺
					int yyy = now.y - dy[h];

					if (nx >= 0 && ny >= 0 && nx <= n - 1 && ny <= m - 1) {

						if (map[nx][ny] == 0 && !check[nx][ny]) { // a
							check[nx][ny] = true;// 没家
							q.add(new point(nx, ny, h + 1));
							break;
						} else if (h == 6 && (check[nx][ny] || map[nx][ny] == 1)) { // 4规氢 促 没家
							if (map[xxx][yyy] == 0) {
								q.add(new point(xxx, yyy, now.z));
								break;
							} else {
								break Loop1;
							}
						}

					}

				}
			}
//			System.out.println("****" + (idx++) + "****************************************");
//			for (int i = 0; i <= n - 1; i++) {
//				for (int j = 0; j <= m - 1; j++) {
//					if (check[i][j])
//						System.out.print("1 ");
//					else {
//						System.out.print("0 ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println();

		}
	}
}
