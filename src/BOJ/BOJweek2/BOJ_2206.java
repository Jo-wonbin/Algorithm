package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class point {
	int a;
	int b;
	int move;
	int drill;

	point(int x, int y, int move, int drill) {
		this.a = x;
		this.b = y;
		this.move = move;
		this.drill = drill;
	}
}

public class BOJ_2206 {

	static Queue<point> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, result = 99999;
	static int x, y;
	static int map[][];
	static int check[][];
	static int dx[] = { 0, 1, 0, -1 }; // �����»�
	static int dy[] = { 1, 0, -1, 0 };
	static ArrayList<point> al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new int[n][m];

		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(a.substring(j, j + 1));
				check[i][j] = 100000;
			}
		}

		bfs();

//		for (int i = 0; i < n; i++) {
//
//			for (int j = 0; j < m; j++) {
//				System.out.print(check[i][j] + " ");
//			}
//			System.out.println();
//		}

		if (result == 99999) {
			bw.write("-1" + "");
		} else
			bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();

	}

	static void bfs() {

		q.add(new point(0, 0, 1, 0));
		check[0][0] = 1;

		while (!q.isEmpty()) {
			point now = q.poll();

			if (now.a == n - 1 && now.b == m - 1) {
				result = now.move;
				return;
			}

			for (int h = 0; h < 4; h++) {
				int nx = now.a + dx[h];
				int ny = now.b + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (check[nx][ny] <= now.drill)// �帱���̶� ���ų� ������ ���͸�
					continue;
				
				if (map[nx][ny] == 0) { // ���� �ƴϸ� �帱�� �״�� ���
					check[nx][ny] = now.drill;
					q.add(new point(nx, ny, now.move + 1, now.drill));

				} else {
					if (now.drill == 0) {
						q.add(new point(nx, ny, now.move + 1, now.drill+1));
						check[nx][ny] = now.drill+1;
					}
				}

			}
		}

	}
}
