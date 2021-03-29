package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int num, n, result = 0;
	static ArrayList<Integer> al[];
	static boolean check[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());

		al = new ArrayList[num + 1];
		check = new boolean[num + 1];
		for (int i = 1; i <= num; i++) {
			al[i] = new ArrayList<Integer>(); // 배열 안에 배열 생성
		}

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			al[x].add(y);
			al[y].add(x);
		}

		bfs();

		bw.write(result + "");
		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		check[1] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < al[now].size(); i++) {
				if (!check[al[now].get(i)]) {
					q.add(al[now].get(i));
					check[al[now].get(i)] = true;
					result += 1;
				}
			}
		}
	}
}
