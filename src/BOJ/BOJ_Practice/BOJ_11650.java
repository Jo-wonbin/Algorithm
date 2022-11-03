package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11650 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		int n = Integer.parseInt(a);
		int map[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				int r = Integer.parseInt(st.nextToken());
				map[i][j] = r;
			}
		}

		Arrays.sort(map, new Comparator<int[]>() {

			@Override
			public int compare(int[] map1, int[] map2) {
				// TODO Auto-generated method stub

				if (map1[0] == map2[0]) {
					return map1[1] - map2[1];
				} else {
					return map1[0] - map2[0];
				}
			}

		});

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
