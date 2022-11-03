package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_11651 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		int n = Integer.parseInt(a);
		int map[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			String b[] = br.readLine().split(" ");
			for (int j = 0; j < 2; j++) {
				int r = Integer.parseInt(b[1-j]);
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
				bw.write(map[i][1] + " " +map[i][0]);
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

}
