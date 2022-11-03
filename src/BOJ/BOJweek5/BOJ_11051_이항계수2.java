package BOJ.BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11051_이항계수2 {

	static int list[][];
	static final int a = 10007;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new int[n + 1][m + 1];

		bw.write(fac(n, m) + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static int fac(int n, int m) {
		if (list[n][m] > 0) {
			return list[n][m];
		}
		if (m == 0 || n == m) {
			return list[n][m] = 1;
		}

		return list[n][m] = (fac(n - 1, m - 1) + fac(n - 1, m)) % a;
	}
}
