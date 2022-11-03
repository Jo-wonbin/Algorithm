package BOJ.BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2004 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n, m, c;

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		c = n - m;

		long cnt2 = count2(n) - count2(c) - count2(m);
		long cnt5 = count5(n) - count5(c) - count5(m);

		if (cnt2 >= cnt5) {
			bw.write(cnt5 + "");
		} else {
			bw.write(cnt2 + "");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static long count2(long num) {
		long count = 0;
		while (num >= 2) {
			count += num / 2;
			num /= 2;
		}

		return count;
	}

	static long count5(long num) {
		long count = 0;
		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}

		return count;
	}
}
