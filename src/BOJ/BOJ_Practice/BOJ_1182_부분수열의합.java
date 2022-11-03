package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int n, s, list[], count, sum;
	static boolean check[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		list = new int[n];
		check = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		count = 0;
		for (int i = 1; i <= n; i++) {
			sum = 0;
			dfs(i, 0, 0);
		}

		bw.write(count + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int max, int num, int cnt) {
		if (max == cnt) {
			if (sum == s) {
				count++;
			}
			return;
		}
		for (int i = num; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				sum += list[i];
				dfs(max, i + 1, cnt + 1);
				check[i] = false;
				sum -= list[i];
			}
		}
	}
}
