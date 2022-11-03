package BOJ.BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {

	static int list[][];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());

		while (num-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			list = new int [n+1][m+1];
			
			bw.write(fac(n, m)+"\n");
			
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static int fac(int n, int m) {
		if(list[n][m] > 0) {
			return list[n][m];
		}
		if(m == 0 || n == m) {
			return list[n][m] = 1;
		}
		
		return list[n][m] = (fac(n-1, m-1) + fac(n-1, m));
	}
}
