package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1206 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = 1;
		while (count < 11) {

			String a = br.readLine();
			int n = Integer.parseInt(a);

			int map[] = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = 2; i < n - 1; i++) {
				if (map[i - 2] > map[i] || map[i - 1] > map[i] || map[i + 1] > map[i] || map[i + 2] > map[i])
					continue;
				if ((map[i] - map[i - 2]) >= 1 && (map[i] - map[i - 1]) >= 1 && (map[i] - map[i + 1]) >= 1 && (map[i] - map[i + 2]) >= 1) {
					
					int x = -1;
					
					for (int j = -2; j <= 2; j++) {
						if (j == 0)
							continue;
						x = Math.max(x, map[i + j]);
					}
					
					cnt = cnt + (map[i] - x);
				}
			}
			bw.write("#" + count + " " + cnt + "\n");
			count += 1;

		}

		br.close();
		bw.flush();
		bw.close();
	}

}
