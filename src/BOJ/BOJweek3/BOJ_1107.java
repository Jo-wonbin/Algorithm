package BOJ.BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1107 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static boolean check[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String len = st.nextToken();

		int size = len.length();
		n = Integer.parseInt(len);

		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		check = new boolean[10];

		if (num != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				int x = Integer.parseInt(st.nextToken());
				check[x] = true;
			}
		}

		int c = Math.abs(n - 100);
		min = Math.min(min, c); // ���Ʒ���ư���θ� ������ ���

		if (size > 0) {
			for (int i = -1; i <= 1; i++) {
				if (size + i > 0) {
					remote(size + i, 0, 0);
				}
			}
		}
		bw.write(min + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void remote(int size, int cnt, int sum) {
		if (cnt == size) {
			if (sum != n) {
				int a = Math.abs(sum - n);
				min = Math.min(min, size + a);
			} else {
				min = Math.min(min, size);
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (check[i])
				continue;
//			if (i == 0 && cnt == size - 1)  //--> �� �κп��� size�� 1�ڸ� �� �� 0�� ��ȯ����Ŵ.
//				continue;
			sum += i * (int) Math.pow(10, cnt);
			remote(size, cnt + 1, sum);
			sum -= i * (int) Math.pow(10, cnt);
		}
	}
}
