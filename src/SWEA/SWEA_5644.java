package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class rng {
	int x, y, range, power, d;

	rng(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	rng(int x, int y, int range, int power) {
		this.x = x;
		this.y = y;
		this.range = range;
		this.power = power;
	}
}

public class SWEA_5644 {

	static int m, bc, result;
	static int A[], B[];
	static int check1[];
	static int check2[];
	static ArrayList<rng> al = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());

		int count = 0;
		while (count < num) {
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			bc = Integer.parseInt(st.nextToken());

			A = new int[m];
			B = new int[m];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < m; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < m; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < bc; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());

				al.add(new rng(y, x, range, power));
			}

			// bfs();
			int cnt = 0;
			int dx[] = { 0, -1, 0, 1, 0 };
			int dy[] = { 0, 0, 1, 0, -1 };
			int ax = 1, ay = 1, bx = 10, by = 10;
			result += chk(ax, ay, bx, by);
			while (cnt < m) {

				ax += dx[A[cnt]];
				ay += dy[A[cnt]];
				bx += dx[B[cnt]];
				by += dy[B[cnt]];
				result += chk(ax, ay, bx, by);
				
				cnt++;
			}

			bw.write("#" + (count + 1) + " " + result + "\n");

			count++;
			al.clear();
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static int chk(int nx1, int ny1, int nx2, int ny2) {
		check1 = new int[bc];
		check2 = new int[bc];

		for (int i = 0; i < bc; i++) {
			int x = al.get(i).x;
			int y = al.get(i).y;
			int range = al.get(i).range;
			int power = al.get(i).power;

			int charge1 = Math.abs(x - nx1) + Math.abs(y - ny1);
			int charge2 = Math.abs(x - nx2) + Math.abs(y - ny2);

			if (charge1 <= range) {
				check1[i] = power;
			}

			if (charge2 <= range) {
				check2[i] = power;
			}

		}

		int end = 0;
		for (int i = 0; i < bc; i++) {
			for (int j = 0; j < bc; j++) {
				if (check1[i] == 0 && check2[j] == 0)
					continue;

				if (check1[i] > 0 && check2[j] == 0) {
					if (end == 0) {
						end = check1[i];
					} else {
						end = Math.max(end, check1[i]);
					}
				}

				else if (check1[i] == 0 && check2[j] > 0) {
					if (end == 0) {
						end = check2[j];
					} else {
						end = Math.max(end, check2[j]);
					}
				}

				else if (check1[i] > 0 && check2[j] > 0) {
					if (i != j) {
						if (end == 0) {
							end = check1[i] + check2[j];
						} else {
							end = Math.max(end, check1[i] + check2[j]);
						}
					} else {
						if (end == 0) {
							end = (check1[i] + check2[j]) / 2;
						} else {
							end = Math.max(end, (check1[i] + check2[j]) / 2);
						}
					}
				}
			}
		}
		return end;
	}

//	static void bfs() {
//		Queue<rng> q1 = new LinkedList<>();
//		Queue<rng> q2 = new LinkedList<>();
//
//		q1.add(new rng(1, 1, A[0]));
//		q2.add(new rng(10, 10, B[0]));
//		result += chk(1, 1, 10, 10);
//
//		int count = 1;
//		while (!q1.isEmpty() && !q2.isEmpty()) {
//
//			rng now1 = q1.poll();
//			rng now2 = q2.poll();
//
//			if (now1.d == 1) {
//				now1.x-=1;
//			} else if (now1.d == 2) {
//				now1.y+=1;
//			} else if (now1.d == 3) {
//				now1.x+=1;
//			} else if (now1.d == 4) {
//				now1.y-=1;
//			}
//
//			if (now2.d == 1) {
//				now2.x-=1;
//			} else if (now2.d == 2) {
//				now2.y+=1;
//			} else if (now2.d == 3) {
//				now2.x+=1;
//			} else if (now2.d == 4) {
//				now2.y-=1;
//			}
//
//			result += chk(now1.x, now1.y, now2.x, now2.y);
//
//			if (count < m) {
//				q1.add(new rng(now1.x, now1.y, A[count]));
//				q2.add(new rng(now2.x, now2.y, B[count]));
//			}
//			count++;
//		}
//	}
}
