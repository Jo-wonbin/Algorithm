package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class qwe {
	int x, y, count;

	qwe(int x, int y) {
		this.x = x;
		this.y = y;
	}

	qwe(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

class pair /* implements Comparable<pair> */ {
	int time;
	int scnt;
	int status;

	pair(int time, int scnt, int status) {
		this.time = time;
		this.scnt = scnt;
		this.status = status;
	}
	/*
	 * @Override public int compareTo(pair o) { // TODO Auto-generated method stub
	 * if (this.time == o.time) { return o.status - this.status; } else { return
	 * this.time - o.time; } }
	 */
}

public class SWEA_2383 {

	static int n, result = Integer.MAX_VALUE;
	static int map[][];
	static int temp;
	static boolean check[];
	static ArrayList<qwe> people = new ArrayList<>();
	static ArrayList<qwe> stair = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());

		int count = 0;
		while (count < num) {

			result = Integer.MAX_VALUE;
			people.clear();
			stair.clear();

			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());

			map = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						people.add(new qwe(i, j));
					}
					if (map[i][j] > 1) {
						stair.add(new qwe(i, j, map[i][j]));
					}
				}
			}

			int c = people.size();
			for (int i = 0; i <= c; i++) {
				int tcnt = i;
				check = new boolean[c];
				dfs(tcnt, 0, 0);
			}
			bw.write("#" + (count + 1) + " " + result + "\n");
			count++;
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static void find() {
		int c = people.size();
		PriorityQueue<pair> pq1 = new PriorityQueue<>(new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return o1.time - o2.time;
			}
		});
		PriorityQueue<pair> pq2 = new PriorityQueue<>(new Comparator<pair>() {

			@Override
			public int compare(pair o1, pair o2) {
				// TODO Auto-generated method stub
				return o1.time - o2.time;
			}
		});

		int s1 = stair.get(0).count;
		int s2 = stair.get(1).count;
		for (int i = 0; i < c; i++) {
			if (check[i]) {
				int sum = Math.abs(people.get(i).x - stair.get(0).x) + Math.abs(people.get(i).y - stair.get(0).y);
				pq1.add(new pair(sum, s1, -1));
			} else {
				int sum = Math.abs(people.get(i).x - stair.get(1).x) + Math.abs(people.get(i).y - stair.get(1).y);
				pq2.add(new pair(sum, s2, -1));
			}
		}

		Queue<pair> q1 = new LinkedList<pair>(); // 계단 1
		Queue<pair> q2 = new LinkedList<>(); // 계단 2

		int timer = 1;

		while (true) {

			// 계단 체크
			int qsize1 = q1.size();
			int qsize2 = q2.size();

			while (qsize1-- > 0) {
				pair now = q1.peek();
				int time = now.time;
				int scnt = now.scnt - 1;

				q1.remove();

				if (scnt > 0) {
					q1.add(new pair(time, scnt, 1));
				}
			}

			while (qsize2-- > 0) {
				pair now = q2.peek();
				int time = now.time;
				int scnt = now.scnt - 1;
				q2.remove();

				if (scnt > 0) {
					q2.add(new pair(time, scnt, 1));
				}
			}

			// 계단 대기열 체크

			int pqsize1 = pq1.size();
			int pqsize2 = pq2.size();

			while (pqsize1-- > 0) {
				pair now = pq1.peek();

				int time = now.time + 1;
				if (time > timer)
					break; // 지금 대기열에서 계단 들어갈 시간 이 되었는지/ 시간이 아직안되었으면 break;

				if (q1.size() < 3) { //
					pq1.remove();
					q1.add(new pair(timer, s1, 1));
				}
			}

			while (pqsize2-- > 0) {
				pair now = pq2.peek();

				int time = now.time + 1;

				if (time > timer)
					break;
				if (q2.size() < 3) { //
					pq2.remove();
					q2.add(new pair(timer, s2, 1));
				}
			}

			if (q1.isEmpty() && q2.isEmpty() && pq1.isEmpty() && pq2.isEmpty())
				break;
			timer++;

		}
		result = Math.min(result, timer);
	}

	static void dfs(int tcnt, int num, int cnt) {
		if (tcnt == cnt) {
			find();
			return;
		}

		int c = people.size();
		for (int i = num; i < c; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(tcnt, i + 1, cnt + 1);
				check[i] = false;
			}
		}
	}
	/*
	 * static void dfs2(int n) { if (n == c) { return; } for (int i = 1; i < 3; i++)
	 * { chk[n] = i; dfs(n + 1); } }
	 */
}