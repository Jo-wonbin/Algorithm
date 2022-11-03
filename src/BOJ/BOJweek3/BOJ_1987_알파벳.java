package BOJ.BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int n, m, max = Integer.MIN_VALUE;
	static char map[][];
	static boolean check[];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		check = new boolean[26];
		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = a.charAt(j);
			}
		}

		dfs(0, 0, 1);

		bw.write(max + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y, int size) {
		check[map[x][y] - 'A'] = true;// �ƽ�Ű�ڵ�� �ش� ���ĺ��� ��ġ�� üũ
		for (int h = 0; h < 4; h++) {
			int nx = x + dx[h];
			int ny = y + dy[h];

			if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
				continue;
			if (!check[map[nx][ny] - 'A'])
				dfs(nx, ny, size + 1);
		}
		check[map[x][y] - 'A'] = false;
		max = Math.max(max, size);
	}
}
