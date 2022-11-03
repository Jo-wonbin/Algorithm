package BOJ.BOJ_Practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {

	static int n, map[], list[];
	static boolean check[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			map = new int[n];
			list = new int[6];
			check = new boolean[n];

			for (int i = 0; i < n; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);
			System.out.println();
		}

		br.close();

	}

	static void dfs(int num, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = num; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				list[cnt] = map[i];
				dfs(i + 1, cnt + 1);
				check[i] = false;

			}
		}
	}
}
