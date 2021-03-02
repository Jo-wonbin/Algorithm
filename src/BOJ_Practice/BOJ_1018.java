package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1018 {
	static int count = 0;
	static int result = 99999;
	static int n, m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < m; j++) {
				if (a.substring(j, j + 1).equals("W")) {
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}

			}
		}
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				find(map, i, j);
			}
		}

		bw.write(result + "");
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				bw.write(map[i][j] + " ");
//			}
//			bw.write("\n");
//		}

		br.close();
		bw.flush();
		bw.close();

	}

	static void find(int map[][], int x, int y) {
		count = 0;
		//W
		if ((x + y) % 2 == 0) {
			for (int i = x; i < x + 8; i++) {
				for (int j = y; j < y + 8; j++) {
					if ((i + j) % 2 == 0) {
						if (map[i][j] != 1) {
							count += 1;
						}
					} else {
						if (map[i][j] != 0) {
							count += 1;
						}
					}
				}

			}
		} else {
			for (int i = x; i < x + 8; i++) {
				for (int j = y; j < y + 8; j++) {
					if ((i + j) % 2 == 1) {
						if (map[i][j] != 1) {
							count += 1;
						}
					} else {
						if (map[i][j] != 0) {
							count += 1;
						}
					}
				}

			}
		}
		if (count < result) {
			result = count;
		}
		
		count = 0;
		//B
		if ((x + y) % 2 == 0) {
			for (int i = x; i < x + 8; i++) {
				for (int j = y; j < y + 8; j++) {
					if ((i + j) % 2 == 0) {
						if (map[i][j] != 0) {
							count += 1;
						}
					} else {
						if (map[i][j] != 1) {
							count += 1;
						}
					}
				}

			}
		} else {
			for (int i = x; i < x + 8; i++) {
				for (int j = y; j < y + 8; j++) {
					if ((i + j) % 2 == 1) {
						if (map[i][j] != 0) {
							count += 1;
						}
					} else {
						if (map[i][j] != 1) {
							count += 1;
						}
					}
				}

			}
		}

		if (count < result) {
			result = count;
		}
	}

}
