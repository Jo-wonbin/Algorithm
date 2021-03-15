package BOJweek6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class w {
	int x, y;

	w(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_17144 {

	static int r, c, t;
	static int map[][];
	static int copy[][];

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static ArrayList<w> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					al.add(new w(i, j));
				}
			}
		}
		int count = 0;
		while (count < t) {
			virus();
			air();
			count++;
		}
		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void virus() {
		copy = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] >= 5) {

					int cnt = 0;
					Loop1: for (int h = 0; h < 4; h++) {
						int nx = i + dx[h];
						int ny = j + dy[h];

						if (nx < 0 || ny < 0 || nx > r - 1 || ny > c - 1)
							continue Loop1;
						if (map[nx][ny] == -1)
							continue Loop1;

						copy[nx][ny] += map[i][j] / 5;
						cnt += 1;

					}

					map[i][j] = map[i][j] - ((map[i][j] / 5) * cnt);
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] += copy[i][j];
			}
		}
	}

	static void air() {
		for (int i = 0; i < 2; i++) {
			int x = al.get(i).x;
			int y = al.get(i).y;

			if (i == 0) {
				for (int j = x; j >= 1; j--) {
					map[j][0] = map[j - 1][0];
				}
				map[x][y] = -1;

				for (int j = 0; j < c - 1; j++) {
					map[0][j] = map[0][j + 1];
				}

				for (int j = 0; j < x; j++) {
					map[j][c - 1] = map[j + 1][c - 1];
				}

				for (int j = c - 1; j >= 1; j--) {
					map[x][j] = map[x][j - 1];
				}
				map[x][y + 1] = 0;
			} else {
				for (int j = x; j < r - 1; j++) {
					map[j][0] = map[j + 1][0];
				}
				map[x][y] = -1;

				for (int j = 0; j < c - 1; j++) {
					map[r - 1][j] = map[r - 1][j + 1];
				}

				for (int j = r - 1; j > x; j--) {
					map[j][c - 1] = map[j - 1][c - 1];
				}

				for (int j = c - 1; j >= 1; j--) {
					map[x][j] = map[x][j - 1];
				}
				map[x][y + 1] = 0;
			}
		}
	}
}
