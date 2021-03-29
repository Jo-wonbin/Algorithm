package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class p {
	int x, y, size;

	p(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}

public class SWEA_1949_µî»ê·Î {

	static int n, k, result, max;
	static int map[][];
	static ArrayList<p> al = new ArrayList<>();
	static Queue<p> q = new LinkedList<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		int count = 0;
		while (count < num) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max < map[i][j]) {
						max = map[i][j];
						al.clear();
						al.add(new p(i, j, 1));
					} else if (max == map[i][j]) {
						al.add(new p(i, j, 1));
					}
				}
			}
			result = -1;
			for (int i = 1; i <= k; i++) {
				drill(0, 0, i, 0);
			}
			bw.write("#" + (count + 1) + " " + result + "\n");
			count++;
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static void drill(int x, int y, int k, int cnt) {
		if (cnt == 1) {
			int c = al.size();
			for (int i = 0; i < c; i++) {
				int a = al.get(i).x;
				int b = al.get(i).y;
				int size = al.get(i).size;
				bfs(a, b, size);
			}
			return;
		}
		for (int i = x; i < n; i++) {
			for (int j = x; j < n; j++) {
				map[i][j] -= k;
				drill(i, j + 1, k, cnt + 1);
				map[i][j] += k;
			}
		}

	}

	static void bfs(int x, int y, int size) {
		q.add(new p(x, y, size));
		int aa = -1;
		
		while (!q.isEmpty()) {
			p now = q.poll();

			if (aa < 0) {
				aa = now.size;
			} else {
				aa = Math.max(aa, now.size);
			}

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
					continue;
				if (map[nx][ny] >= map[now.x][now.y])
					continue;

				q.add(new p(nx, ny, now.size + 1));
			}
		}		
		result = Math.max(result, aa);
	}
}
