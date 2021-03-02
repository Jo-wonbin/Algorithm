package BOJweek2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {
	
	static int n, m;
	static int check[];
	static String a;
	static ArrayList<Integer>[] al;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int count = 1;
		while (count <= k) {

			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			check = new int[n + 1];

			al = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) {

				al[i] = new ArrayList<Integer>(); // 배열 안에 배열 생성

			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				al[a].add(b); // a 접점의 노드 b를 저장
				al[b].add(a); // b 접점의 노드 a를 저장

			}

			bfs();

//			for (int i = 0; i <= check.length; i++) {
//				bw.write(check[i] + " ");
//			}

			bw.write(a + "\n");
			count += 1;
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {

			if (check[i] == 0) {
				q.add(i);
				check[i] = 1;
			}
			while (!q.isEmpty()) {
				int now = q.poll();

				for (int j = 0; j < al[now].size(); j++) {
					int tp = al[now].get(j);

					if (check[tp] == 0) {
						q.add(tp);
					}
					if (check[tp] == check[now]) {
						a = "NO";
						return;
					}
					if (check[now] == 1 && check[tp] == 0) {
						check[tp] = 2;
					} else if (check[now] == 2 && check[tp] == 0) {
						check[tp] = 1;
					}

				}
			}
		}
		a = "YES";
	}

}
