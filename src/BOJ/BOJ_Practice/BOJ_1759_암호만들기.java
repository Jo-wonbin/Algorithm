package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기{
	static int n, m;
	static char[] list;
	static char[] copy;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new char[m];
		check = new boolean[m];
		copy = new char[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(list);

		dfs(0, 0, 0, 0);

		br.close();

	}

	static void dfs(int num, int cnt, int mc, int jc) {
		if (cnt == n) {
			if (mc >= 1 && jc >= 2) {
				for (int i = 0; i < n; i++) {
					System.out.print(copy[i] + "");
				}
				System.out.println();
			}
			return;
		}

		for (int i = num; i < m; i++) {
			if (!check[i]) {
				check[i] = true;
				copy[cnt] = list[i];
				if (copy[cnt] == 'a' || copy[cnt] == 'e' || copy[cnt] == 'i' || copy[cnt] == 'o' || copy[cnt] == 'u')
					mc++;
				else
					jc++;
				dfs(i + 1, cnt + 1, mc, jc);
				if (copy[cnt] == 'a' || copy[cnt] == 'e' || copy[cnt] == 'i' || copy[cnt] == 'o' || copy[cnt] == 'u')
					mc--;
				else
					jc--;
				check[i] = false;
			}
		}
	}
}
