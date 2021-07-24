package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17779_게리멘더링2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int n, result = Integer.MAX_VALUE;
		int map[][], sector[][];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		sector = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max;
		int min;

		for (int x = 1; x <= n; x++) {
			for (int y = 2; y <= n - 1; y++) {
				for (int d1 = 1; d1 <= n - 1; d1++) {
					for (int d2 = 1; d2 <= n - 1; d2++) {
						if (x + d1 + d2 > n || y - d1 < 1 || y + d2 > n)
							continue;

						sector = new int[n + 1][n + 1];
						int count[] = new int[6];

						for (int i = 1; i <= n; i++) {
							for (int j = 1; j <= n; j++) {

								if (check(x, y, d1, d2, i, j)) {
									sector[i][j] = 5;
									count[5] += map[i][j];
								}
								if (sector[i][j] != 5) {

									if (i < x + d1 && j <= y) {
										sector[i][j] = 1;
										count[1] += map[i][j];
									} else if (i <= x + d2 && j > y) {
										sector[i][j] = 2;
										count[2] += map[i][j];
									} else if (i >= x + d1 && j < y - d1 + d2) {
										sector[i][j] = 3;
										count[3] += map[i][j];
									} else if (i > x + d2 && j >= y - d1 + d2) {
										sector[i][j] = 4;
										count[4] += map[i][j];
									}
								}
							}
						}

						max = Integer.MIN_VALUE;
						min = Integer.MAX_VALUE;
						for (int h = 1; h <= 5; h++) {
							max = Math.max(max, count[h]);
							min = Math.min(min, count[h]);
						}
						result = Math.min(result, max - min);

					}
				}
			}
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static boolean check(int x, int y, int d1, int d2, int a, int b) {

		int dl = 0;
		int dr = 0;
		boolean type1 = true;
		boolean type2 = true;

		for (int i = x; i <= x + d1 + d2; i++) {
			for (int j = y - dl; j <= y + dr; j++) {
				if (a == i && b == j)
					return true;
			}
			if (dl < d1 && type1) {
				dl++;
			} else {
				type1 = false;
				dl--;
			}
			if (dr < d2 && type2) {
				dr++;
			} else {
				type2 = false;
				dr--;
			}
		}
		return false;
	}
}
