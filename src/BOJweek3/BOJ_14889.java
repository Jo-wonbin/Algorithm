package BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14889 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int map[][];
	static boolean check[];
	static int result = 988654;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String a = br.readLine();
		n = Integer.parseInt(a);

		map = new int[n][n];
		check = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				bw.write(map[i][j] + " ");
//			}
//			bw.write("\n");
//		}

		dfs(0, 0);

		
		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int cnt, int num) throws IOException {

		if (cnt == n / 2) {
			minus();
			return;
		}

		for (int i = num; i < n; i++) {  // n°úm
			if (!check[i]) {

				check[i] = true; 

				dfs(cnt + 1, i + 1); 

				check[i] = false;

			}
		}

	}

	static void minus() throws IOException {

		int start = 0;
		int link = 0;

		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (check[i] && check[j] && i != j) {
					start = start + map[i][j] + map[j][i];
				} else if (!check[i] && !check[j] && i != j) {
					link = link + map[i][j] + map[j][i];
				}
			}
		}

		result = Math.min(result, Math.abs(start - link));

	}
}
