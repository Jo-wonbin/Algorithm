package BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14499 {
	static int n, m, x, y, num;
	static int map[][];
	static int list[];
	static int ud[] = new int[4];// 주사위 위아래 이동
	static int lr[] = new int[4];// 주사위 좌우 이동

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		list = new int[num];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < num; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 4; i++) {
			ud[i] = 0;
			lr[i] = 0;
		}

		Loop1: for (int i = 0; i < num; i++) {

			switch (list[i]) {
			case 1:
				if (y < m - 1 && m != 1) {
					y++;
					bw.write(roll(x, y, 1) + "\n");
				} else {
					continue Loop1;
				}
				break;
			case 2:
				if (y > 0 && m != 1) {
					y--;
					bw.write(roll(x, y, 2) + "\n");
				} else {
					continue Loop1;
				}
				break;
			case 3:
				if (x > 0 && n != 1) {
					x--;
					bw.write(roll(x, y, 3) + "\n");
				} else {
					continue Loop1;
				}
				break;
			case 4:
				if (x < n - 1 && n != 1) {
					x++;
					bw.write(roll(x, y, 4) + "\n");
				} else {
					continue Loop1;
				}
				break;
			}

		}

		br.close();
		bw.flush();
		bw.close();
	}

	static int roll(int x, int y, int dir) {
		if (dir == 1) {
			int tp1 = lr[0];

			for (int i = 0; i <= 2; i++) {
				lr[i] = lr[i + 1];
			}
			lr[3] = tp1;
			ud[1] = lr[1];
			ud[3] = lr[3];

		} else if (dir == 2) {
			int tp3 = lr[3];

			for (int i = 3; i >= 1; i--) {
				lr[i] = lr[i - 1];
			}
			lr[0] = tp3;
			ud[1] = lr[1];
			ud[3] = lr[3];

		} else if (dir == 3) {
			int tp1 = ud[0];

			for (int i = 0; i <= 2; i++) {
				ud[i] = ud[i + 1];
			}
			ud[3] = tp1;
			lr[1] = ud[1];
			lr[3] = ud[3];

		} else {
			int tp3 = ud[3];

			for (int i = 3; i >= 1; i--) {
				ud[i] = ud[i - 1];
			}
			ud[0] = tp3;
			lr[1] = ud[1];
			lr[3] = ud[3];
		}
		if (map[x][y] == 0) {
			map[x][y] = lr[1];
		} else {
			lr[1] = map[x][y];
			ud[1] = map[x][y];
			map[x][y] = 0;
		}

		return ud[3];
	}
}
