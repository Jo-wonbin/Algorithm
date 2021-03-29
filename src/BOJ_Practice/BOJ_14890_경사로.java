package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14890_°æ»ç·Î {
	static int n, l, result = 0;
	static int map[][];
	static int temp[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		temp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			if (find(i, 0))
				result++;
			if (find(i, 1))
				result++;
		}

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static boolean find(int x, int dir) {
		if (dir == 0) {
			for (int i = 1; i <= n; i++) {
				temp[i] = map[x][i];
			}
		} else {
			for (int i = 1; i <= n; i++) {
				temp[i] = map[i][x];
			}
		}

		boolean check[] = new boolean[n + 1];

		for (int cnt = 1; cnt <= n - 1; cnt++) {
			if (temp[cnt] == temp[cnt + 1]) {
				continue;
			}

			if (Math.abs(temp[cnt] - temp[cnt + 1]) > 1)
				return false;

			if (temp[cnt] - 1 == temp[cnt + 1]) {
				for (int j = cnt + 1; j <= cnt + l; j++) {
					if (j >= n + 1 || check[j] || temp[j] != temp[cnt + 1]) {
						return false;
					}
					check[j] = true;
				}
			} else if (temp[cnt] + 1 == temp[cnt + 1]) {
				for (int j = cnt; j > cnt - l; j--) {
					if (j < 0 || check[j] || temp[j] != temp[cnt]) {
						return false;
					}
					check[j] = true;
				}
			}
		}
		return true;
	}
}
