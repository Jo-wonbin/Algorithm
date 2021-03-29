package BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class pt {
	int x, y, type;

	pt(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class BOJ_15683 {
	static int n, m, result = Integer.MAX_VALUE;
	static ArrayList<pt> al = new ArrayList<>();
	static int dx[] = { -1, 0, 1, 0 }; // 시계방향
	static int dy[] = { 0, 1, 0, -1 };
	static int[][] dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					al.add(new pt(i, j, map[i][j]));
				}
			}
		}

		find(0, map);
		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static int[][] copy(int arr[][]) {
		int map[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = arr[i][j];
			}
		}
		return map;
	}

	static void find(int cnt, int arr[][]) {
		if (al.size() == cnt) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0)
						count++;
				}
			}
			result = Math.min(result, count);
			return;
		}

		int x = al.get(cnt).x;
		int y = al.get(cnt).y;
		int type = al.get(cnt).type;

		for (int h = 0; h < 4; h++) {
			int map[][] = copy(arr);

			for (int i = 0; i < dir[type].length; i++) {
				int nd = (dir[type][i] - h + 3) % 4;
				int nx = x;
				int ny = y;

				while (true) {
					nx += dx[nd];
					ny += dy[nd];

					if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1 || map[nx][ny] == 6)
						break;

					map[nx][ny] = -1;
				}
			}

			find(cnt + 1, map);
		}

	}

}
