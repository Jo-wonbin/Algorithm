package BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class find implements Comparable<find> {
	int a;
	int cnt;

	find(int x, int cnt) {
		this.a = x;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(find o) { // 오름차순
		// TODO Auto-generated method stub
		return cnt - o.cnt;
	}
}

public class BOJ_13549 {

	static PriorityQueue<find> q = new PriorityQueue<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, result;
	static boolean check[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		check = new boolean[200002];

		bfs();

		bw.write(result + "");

		br.close();
		bw.flush();
		bw.close();

	}

	static void bfs() {

		q.add(new find(n, 0));
		check[n] = true;

		while (!q.isEmpty()) {
			find now = q.poll();
			if (now.a == m) {
				result = now.cnt;
				return;
			}
			int dx[] = { now.a, -1, 1 };
			check[now.a] = true; // 우선순위큐라서 들어가기 전에 중복체크
			for (int h = 0; h < 3; h++) {
				int nx = now.a + dx[h];

				if (nx < 0 || nx > 200000)
					continue;
				if (check[nx])
					continue;
				if (h == 0 && now.a > m)
					continue;

				if (h == 0) {
					q.add(new find(nx, now.cnt));
				} else {
					q.add(new find(nx, now.cnt + 1));
				}
			}
		}
	}
}