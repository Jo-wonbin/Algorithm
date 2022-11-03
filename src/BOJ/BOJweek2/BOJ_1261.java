package BOJ.BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class spot implements Comparable<spot> {
	int a;
	int b;
	int drill;

	spot(int x, int y, int drill) {
		this.a = x;
		this.b = y;
		this.drill = drill;
	}

	@Override
	public int compareTo(spot o) { // ��������
		// TODO Auto-generated method stub
		return drill - o.drill;
	}
}

public class BOJ_1261 {

	static PriorityQueue<spot> q = new PriorityQueue<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, result = 99999;
	static int map[][];
	static boolean check[][];
	static int dx[] = { 0, 1, 0, -1 }; // �����»�
	static int dy[] = { 1, 0, -1, 0 };
	static ArrayList<spot> al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(a.substring(j, j + 1));
			}
		}

		bfs();

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();

	}

	static void bfs() {

		q.add(new spot(0, 0, 0));
		check[0][0] = true;

		while (!q.isEmpty()) {
			spot now = q.poll();

			if (now.a == n - 1 && now.b == m - 1) {
				result = now.drill;
				return;
			}

			for (int h = 0; h < 4; h++) {
				int nx = now.a + dx[h];
				int ny = now.b + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1)
					continue;
				if (check[nx][ny])// �帱���̶� ���ų� ������ ���͸�
					continue;

				if (map[nx][ny] == 0) { // ���� �ƴϸ� �帱�� �״�� ���
					check[nx][ny] = true;
					q.add(new spot(nx, ny, now.drill));

				} else {
					q.add(new spot(nx, ny, now.drill + 1));
					check[nx][ny] = true;

				}
			}
		}
	}
}