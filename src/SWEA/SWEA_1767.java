package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pwt {
	int x, y;

	pwt(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SWEA_1767 {
	static int n;
	static int map[][];
	static ArrayList<pwt> al = new ArrayList<>();
	static int maxCore, minLength;
	static int dx[] = { -1, 0, 1, 0 };// »ó¿ìÇÏÁÂ
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());

		int cnt = 0;
		while (cnt < num) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());

			map = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 1 || j == 1 || i == n || j == n) {
							continue;
						} else {
							al.add(new pwt(i, j));
						}
					}
				}
			}

			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;

			dfs(0, 0, 0);

			bw.write("#" + (cnt + 1) + " " + minLength + "\n");
			cnt++;
			al.clear();
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int coreCnt, int num, int cnt) {
		if (cnt == al.size()) {
			if (maxCore < coreCnt) {
				maxCore = coreCnt;
				minLength = num;
			} else if (maxCore == coreCnt) {
				if (minLength > num) {
					minLength = num;
				}
			}
			return;
		}

		int x = al.get(cnt).x;
		int y = al.get(cnt).y;

		for (int h = 0; h < 4; h++) {
			int count = 0;
			int nx = x;
			int ny = y;
			int sx = x;
			int sy = y;

			while (true) {
				nx += dx[h];
				ny += dy[h];
				if (nx < 1 || ny < 1 || nx > n || ny > n)
					break;
				if (map[nx][ny] == 1) {
					count = 0;
					break;
				}
				count++;
			}

			for (int i = 0; i < count; i++) {
				sx += dx[h];
				sy += dy[h];

				map[sx][sy] = 1;
			}

			if (count == 0) {
				dfs(coreCnt, num, cnt + 1);
			} else {
				dfs(coreCnt + 1, num + count, cnt + 1);

				sx = x;
				sy = y;

				for (int i = 0; i < count; i++) {
					sx += dx[h];
					sy += dy[h];

					map[sx][sy] = 0;
				}
			}
		}
	}
}
