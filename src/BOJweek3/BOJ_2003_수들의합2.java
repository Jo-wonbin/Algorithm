package BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		long list[] = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list[i] = Long.parseLong(st.nextToken());
		}
		long result;
		int cnt = 0;
		int count = 0;
		int tcnt = 0;
		while (tcnt <= n - 1) {
			result = 0;
			for (int i = count; i < n; i++) {
				result += list[i];
				if (result == m) {
					count++;
					cnt++;
					break;
				} else if (result > m) {
					count++;
					break;
				}
			}
			tcnt++;
		}
		bw.write(cnt + "");
		br.close();
		bw.flush();
		br.close();
	}

}
