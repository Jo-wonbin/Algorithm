package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_7568 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		int n = Integer.parseInt(a);

		int list[][] = new int[n][3];

		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[i][0] = x;
			list[i][1] = y;
			list[i][2] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i != j) {
					if(list[i][0] < list[j][0] && list[i][1] < list[j][1]) {
						list[i][2] += 1; 
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
				bw.write(list[i][2] + " ");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
