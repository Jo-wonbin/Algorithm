package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class glass implements Comparable<glass> {
	int x, y, gcnt, dir;

	glass(int x, int y, int gcnt, int dir) {
		this.x = x;
		this.y = y;
		this.gcnt = gcnt;
		this.dir = dir;
	}

	@Override
	public int compareTo(glass o) {
		// TODO Auto-generated method stub
		if (this.gcnt > o.gcnt) {
			return 1;
		} else if (this.gcnt < o.gcnt) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class BOJ_6087 {
	static int x, y, result = -1;
	static PriorityQueue<glass> q = new PriorityQueue<>();
	static int dx[] = { 0, -1, 0, 1, 0 };// 상우하좌
	static int dy[] = { 0, 0, 1, 0, -1 };
	static int map[][];
	static boolean check[][];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new int[x][y];
		check = new boolean[x][y];

		boolean chk = false;
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			for (int j = 0; j < y; j++) {
				if (a.substring(j, j + 1).equals(".")) {
					map[i][j] = 0;
				} else if (a.substring(j, j + 1).equals("*")) {// 벽
					map[i][j] = 2;
				} else if (a.substring(j, j + 1).equals("C")) {// 목표
					if (!chk) {
						map[i][j] = 0;
						q.add(new glass(i, j, 0, 0)); // 출발
						check[i][j] = true;
						chk = true;
					} else {
						map[i][j] = 1;// 도착
					}
				}
			}
		}
		bfs();

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			glass now = q.poll();
			check[now.x][now.y] = true;

			if (map[now.x][now.y] == 1) {
				result = now.gcnt;
				return;
			}

			for (int h = 1; h <= 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > x - 1 || ny > y - 1)
					continue;
				if (map[nx][ny] == 2)
					continue;
				if (check[nx][ny])
					continue;

				if (now.dir == 1 || now.dir == 3) {
					if (h == 2 || h == 4) {
						q.add(new glass(nx, ny, now.gcnt + 1, h));
					} else {
						q.add(new glass(nx, ny, now.gcnt, now.dir));
					}
				} else if (now.dir == 2 || now.dir == 4) {
					if (h == 1 || h == 3) {
						q.add(new glass(nx, ny, now.gcnt + 1, h));
					} else {
						q.add(new glass(nx, ny, now.gcnt, now.dir));
					}
				} else {
					q.add(new glass(nx, ny, now.gcnt, h));
				}
			}
		}
	}
}
