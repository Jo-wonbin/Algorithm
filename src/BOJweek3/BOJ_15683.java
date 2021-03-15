package BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int n, m;
	static int map[][];
	static boolean check[][];
	static int dx[] = { -1, 0, 1, 0 }; // 시계방향
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(map[i][j]+" ");
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
//	static void copyMap(int [][]map, int [][]copy) {
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=m; j++) {
//				copy[i][j] = map[i][j];
//			}
//		}
//	}

}
