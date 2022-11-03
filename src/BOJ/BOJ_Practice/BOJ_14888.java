package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14888 {

	static int num, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int list[], chk[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());

		list = new int[num];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < num; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		chk = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			chk[i] = Integer.parseInt(st.nextToken());

		}

		dfs(list[0], 1);

		bw.write(max + "\n" + min + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int cnt) {
		if (cnt == num) {
			max = Math.max(max, x);
			min = Math.min(min, x);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (chk[i] > 0) {

				chk[i]--;

				switch (i) {
				case 0:
					dfs(x + list[cnt], cnt + 1);
					break;
				case 1:
					dfs(x - list[cnt], cnt + 1);
					break;
				case 2:
					dfs(x * list[cnt], cnt + 1);
					break;
				case 3:
					dfs(x / list[cnt], cnt + 1);
					break;
				}

				chk[i]++;
			}

		}
	}

}
