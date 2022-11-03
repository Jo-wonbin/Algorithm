package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class shark implements Comparable<shark> {
	int x, y, sx, sy, size, num;

	shark(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	shark(int x, int y) {
		this.x = x;
		this.y = y;
	}

	shark(int num, int sx, int sy, int size) {
		this.num = num;
		this.sx = sx;
		this.sy = sy;
		this.size = size;
	}

	@Override
	public int compareTo(shark o) {
		// TODO Auto-generated method stub
		if (this.size > o.size) {
			return 1;
		} else if (this.size == o.size) {
			if (this.sx > o.sx) {
				return 1;
			} else if (this.sx == o.sx) {
				if (this.sy > o.sy) {
					return 1;
				} else if (this.sy < o.sy) {
					return -1;
				} else
					return 0;
			}
		} else {
			return -1;
		}
		return 0;
	}
}

public class BOJ_16236_아기상어 {
	static int n, result = 0, SS = 0;
	static int map[][];
	static int check[][];
	static LinkedList<shark> al = new LinkedList<>();
	static PriorityQueue<shark> min = new PriorityQueue<>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean type = true;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] <= 6) {
					al.addLast(new shark(i, j, map[i][j]));
				}
				if (map[i][j] == 9) {
					al.addFirst(new shark(i, j, 2));
				}
			}
		}

		while (type) {
			type = false;
			check = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(check[i], -1);
			}
			bfs();
		}
		bw.write(result + "");
		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<shark> q = new LinkedList<>();
		int x = al.get(0).x;
		int y = al.get(0).y;
		int ssize = al.get(0).size;

		q.add(new shark(x, y));
		check[x][y] = 0;

		while (!q.isEmpty()) {
			shark now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
					continue;
				if (map[nx][ny] > ssize)
					continue;
				if (check[nx][ny] > -1)
					continue;

				check[nx][ny] = check[now.x][now.y] + 1;
				q.add(new shark(nx, ny));
			}
		}

		for (int i = 1; i < al.size(); i++) {
			int sx = al.get(i).x;
			int sy = al.get(i).y;
			int fsize = al.get(i).size;

			if (fsize < ssize && check[sx][sy] != -1) {
				min.add(new shark(i, sx, sy, check[sx][sy]));
				type = true;
			}
		}
		if (min.size() != 0) {
			shark m = min.poll();
			al.remove(m.num);
			SS++;
			al.removeFirst();
			if (SS == ssize) {
				al.addFirst(new shark(m.sx, m.sy, ssize + 1));
				SS = 0;
			} else {
				al.addFirst(new shark(m.sx, m.sy, ssize));
			}

			map[x][y] = 0;
			map[m.sx][m.sy] = 9;
			result += m.size;
			min.clear();
		}
	}
}
