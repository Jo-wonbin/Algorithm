package BOJweek4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class locat {
	int x;
	int y;
	int z;

	locat(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class BOJ_15558 {

	static Queue<locat> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, k;
	static int map[][];
	static boolean check[][];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[2][n + k];
		check = new boolean[2][n + k];

		for (int i = 0; i < 2; i++) {
			String a = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(a.substring(j, j + 1));
			}
		}
//		for (int i = 0; i < 2; i++) {
//			for (int j = n; j < n + k; j++) {
//				map[i][j] = 2;
//			}
//		}

		bfs();

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {

		q.offer(new locat(0, 0, 0));
		check[0][0] = true;
		int dx[] = { 0, 0, 1, -1 }; // 앞뒤 대각선 대각선 체크
		int dy[] = { 1, -1, k, k };
		int nx = 0;
		int ny = 0;
		while (!q.isEmpty()) {

			locat now = q.poll();

			if (now.y >= n) {
				result = 1;
				return;
			}

			for (int h = 0; h < 4; h++) {
				nx = now.x + dx[h];
				ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > 1 || ny <= now.z)
					continue;
				if (map[nx][ny] == 0 && ny < n)
					continue;
				if (check[nx][ny])
					continue;

				// System.out.printf("%d -- %d -- %d --\n",nx ,ny, now.z);
				q.offer(new locat(nx, ny, now.z + 1));
				check[nx][ny] = true;
				// System.out.printf("%d -- %d -- %d --\n",nx ,ny, now.z+1);
			}

		}
		result = 0;
	}

}
