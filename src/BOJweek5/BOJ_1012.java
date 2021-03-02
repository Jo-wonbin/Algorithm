package BOJweek5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location {
	int x, y;

	location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_1012 {

	static int n, m, k;
	static int map[][];
	static boolean check[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int count = 1;

		while (count <= num) {

			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[m][n];
			check = new boolean[m][n];
			ArrayList<location> al = new ArrayList<location>();
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				map[a][b] = 1;
				al.add(new location(a, b));
			}

			int cnt = 0;
			for (int i = 0; i < al.size(); i++) {
				int c = al.get(i).x;
				int d = al.get(i).y;
				if (!check[c][d]) {
					bfs(c, d);
					cnt += 1;
				}
			}
//			for(int i=0; i<m; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(check[i][j]+ " ");
//				}
//				System.out.println();
//			}
			bw.write(cnt +"\n");
			count+=1;
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs(int c, int d) {
		Queue<location> q = new LinkedList<>();

		q.add(new location(c, d));
		check[c][d] = true;

		while (!q.isEmpty()) {

			location now = q.poll();

			for (int h = 0; h < 4; h++) {
				int nx = now.x + dx[h];
				int ny = now.y + dy[h];

				if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1)
					continue;
				if (check[nx][ny])
					continue;
				if (map[nx][ny] == 0)
					continue;

				check[nx][ny] = true;
				q.add(new location(nx, ny));
			}

		}
	}

}
