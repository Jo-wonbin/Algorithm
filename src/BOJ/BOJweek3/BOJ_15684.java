package BOJ.BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15684 {

	static int n, m, h, answer;
	static int map[][];
	static boolean finish = false;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h + 1][n + 1];
		
		int a, b;
		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			map[a][b] = 1;
			map[a][b + 1] = 2;
		}

		for (int i = 0; i <= 3; i++) {
			answer = i;
			dfs(1, 0);
			if (finish)
				break;
		}
		
		if(finish) {
			bw.write(answer+"");
		}else {
			bw.write("-1");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int x, int count) {
		if (finish)
			return;
		if (answer == count) {
			if (check())
				finish = true;
			return;
		}
		for (int i = x; i < h + 1; i++) {
			for (int j = 1; j < n; j++) {
				if (map[i][j] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					map[i][j + 1] = 2;
					dfs(i, count + 1);
					map[i][j] = map[i][j + 1] = 0;
				}
			}
		}
	}

	private static boolean check() {
		for (int i = 1; i <= n; i++) {
			int x = 1, y = i;
			for (int j = 0; j < h; j++) {
				if (map[x][y] == 1)
					y++;
				else if (map[x][y] == 2)
					y--;
				x++;
			}
			if (y != i)
				return false;
		}
		return true;
	}

}
