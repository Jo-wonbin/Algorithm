package BOJweek6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17140 {

	static int r, c, k;
	static int map[][];
	static int resultC, cntR;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[101][101];

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		while (count <= 100) {
			if (map[r][c] == k) {
				break;
			}

			if (check()) {
				r();
			} else {
				c();
			}
			
			count++;
		}

		if (count == 101) {
			bw.write("-1");
		} else {
			bw.write(count + "");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static boolean check() {
		cntR = 0;
		resultC = -1;
		for (int i = 1; i <= 100; i++) {
			int cntC = 0;
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] != 0) {
					cntC++;
				}
				if (resultC < 0) {
					resultC = cntC;
				} else {
					resultC = Math.max(resultC, cntC);
				}
			}
			if (cntC == 0) {
				break;
			} else {
				cntR++;
			}
		}
		if (resultC > cntR) {
			return false;
		} else {
			return true;
		}
	}

	static void r() {
		for (int i = 1; i <= cntR; i++) {
			int check[] = new int[101];
			for (int j = 1; j <= resultC; j++) {
				check[map[i][j]] += 1;
			}
			Arrays.fill(map[i], 0);

			int y = 1;
			for (int tcnt = 1; tcnt <= 100; tcnt++) {
				for (int h = 1; h <= 100; h++) {
					if (check[h] == tcnt) {
						map[i][y] = h;
						y += 1;
						map[i][y] = tcnt;
						y += 1;
						if (y > 100) {
							break;
						}
					}
				}
			}
		}
	}

	static void c() {
		for (int i = 1; i <= resultC; i++) {
			int check[] = new int[101];
			for (int j = 1; j <= cntR; j++) {
				check[map[j][i]] += 1;
			}
			for (int z = 1; z <= 100; z++) {
				map[z][i] = 0;
			}

			int y = 1;
			for (int tcnt = 1; tcnt <= 100; tcnt++) {
				for (int h = 1; h <= 100; h++) {
					if (check[h] == tcnt) {
						map[y][i] = h;
						y += 1;
						map[y][i] = tcnt;
						y += 1;
						if (y > 100) {
							break;
						}
					}
				}
			}
		}
	}

}
