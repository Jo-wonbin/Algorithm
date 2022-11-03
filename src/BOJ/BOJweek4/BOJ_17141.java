package BOJ.BOJweek4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class loc {
	int x;
	int y;

	loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_17141 {

	static Queue<loc> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int[][] map;
	static boolean[] mapchk;
	static int[][] copy;
	static int[][] check;
	static int dx[] = { -1, 0, 1, 0 }; // �������
	static int dy[] = { 0, 1, 0, -1 };
	static int result = -1;
	static ArrayList<loc> al = new ArrayList<>();
	static ArrayList<Integer> end = new ArrayList<>();
	static boolean chk = false;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String a[] = br.readLine().split(" ", 2);
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);

		map = new int[n][n];
		copy = new int[n][n];
		check = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					al.add(new loc(i, j));
				}
				check[i][j] = -1;
			}
		}
		mapchk = new boolean[al.size()];

		point(0, 0);
		if(chk) {
			Collections.sort(end);
			bw.write(end.get(0) + "");
		}else
			bw.write("-1");
		br.close();
		bw.flush();
		bw.close();
	}

	static void point(int cnt, int num) throws IOException { // ���̷��� �۶߸� ��ġ Ž��
		if (cnt == m) {
			bfs();
			return;
		}

		for (int i = num; i < al.size(); i++) {		// ��ͷ� Ž��
			if (!mapchk[i]) {
				mapchk[i] = true;
				point(cnt + 1, i + 1);
				mapchk[i] = false;
			}
		}
	}

	static void bfs() throws IOException {

		copyMap(map, copy);
		for (int i = 0; i < al.size(); i++) {
			if (mapchk[i]) {
				int x = al.get(i).x;
				int y = al.get(i).y;
				q.add(new loc(x, y));
				check[x][y] = 0;
			}
		}

		while (!q.isEmpty()) {
			loc now = q.poll(); // ť���� now�� �����ϰ� ����

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h]; // �����¿� bfsŽ��
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1)
					continue;
				if (copy[nx][ny] == 1)
					continue;
				if (check[nx][ny] > -1)
					continue;

				check[nx][ny] = check[now.x][now.y] + 1;
				copy[nx][ny] = 2;
				q.offer(new loc(nx, ny));

			}

		}

		int c = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copy[i][j] == 0) {
					c+=1;
				}
			}
		}
		
		if(c==0) {				// copy�� �ѹ��̶� 0�� ������ chk�� true
			chk = true;
		}
		
		if(c==0) {								// copy�� 0�� ���� ��� �ִ밪 ���
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result = Math.max(result, check[i][j]);
				}
			}
			end.add(result);
		}

		for (int i = 0; i < n; i++) {			//üũ �ʱ�ȭ, resu��t �ʱ�ȭ
			Arrays.fill(check[i], -1);
		}
		result = -1;
	}

	static void copyMap(int[][] map, int[][] copy) {	// �� ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

}
