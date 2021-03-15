package BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class chk {
	int x, y;

	chk(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_15686 {

	static int n, m;
	static int map[][];
	static boolean check[];
	static int result;
	static int end = 99999;
	static int endR = 99999;
	static int d = 0;
	static ArrayList<chk> al = new ArrayList<>();
	static ArrayList<chk> one = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					al.add(new chk(i, j));
				}
				if (map[i][j] == 1) {
					one.add(new chk(i, j));
				}
			}
		}
		check = new boolean[al.size()];
		dfs(0, 0);

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				bw.write(map[i][j] + " ");
//			}
//			bw.write("\n");
//		}
		bw.write(endR + "");

		br.close();
		bw.flush();
		bw.close();
	}

	static void dfs(int num, int cnt) {
		if (cnt == m) {
			d = 0;
			bfs();
			return;
		}

		for (int i = num; i < al.size(); i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(i + 1, cnt + 1);
				check[i] = false;
			}
		}
	}

	static void bfs() {
		Queue<chk> q = new LinkedList<>();

		for (int i = 0; i < one.size(); i++) {// 1의 좌표 큐에 넣음
			int x = one.get(i).x;
			int y = one.get(i).y;
			q.add(new chk(x, y));
		}

		while (!q.isEmpty()) {// 1의 좌표 한 개 마다 치킨집과의 거리중 최소거리를 저장
			end = 99999;
			chk now = q.poll();

			for (int i = 0; i < al.size(); i++) {
				if (check[i]) {
					int x = al.get(i).x;
					int y = al.get(i).y;
					result = Math.abs(now.x - x) + Math.abs(now.y - y);
					if (end > result) {
						end = result;
					}
				}
			}
//			System.out.println("----" + end + "--");
			d += end;
//			System.out.println("----" + d + "-------");
		}
		if (endR > d) {
			endR = d;
		}
//		System.out.println(endR + "-------");
	}

}
