package BOJweek6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9663 {

	static int n;
	static int map[];
	static int count = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		map = new int[n + 1];

		if (n == 1) {
			bw.write("1");
		} else {
			dfs(1);
			bw.write(count + "");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static boolean check(int cnt) {

		if (cnt == 1) {
			return true;
		} else {
			for (int i = 1; i < cnt; i++) {
				if(map[cnt] == map[i]) {
					return false;
				}else if (Math.abs(cnt - i) == Math.abs(map[cnt] - map[i])) {
					return false;
				}
			}
			
			
		}

		return true;
	}

	static void dfs(int cnt) {
		if (cnt == n + 1) {
			count++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			map[cnt] = i;
			if (check(cnt)) {
				dfs(cnt + 1);
			}
		}
	}
}
