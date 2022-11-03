package BOJ.BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11050_이항계수1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int a = n - m;
		int result = 1;
		if (a != 0) {
			for (int i = n; i >= a+1; i--) {
				result *= i;
			}
			int b = 1;
			for (int i = m; i >= 1; i--) {
				b *= i;
			}
			result /= b;
			bw.write(result + "");
		} else {
			bw.write("1");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
