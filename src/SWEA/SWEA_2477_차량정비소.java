package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class car implements Comparable<car> {
	int cnum, aTime, changgu;

	public car(int cnum, int aTime, int changgu) {
		super();
		this.cnum = cnum;
		this.aTime = aTime;
		this.changgu = changgu;
	}

	@Override
	public int compareTo(car o) {
		// TODO Auto-generated method stub
		if (this.aTime > o.aTime) {
			return 1;
		} else if (this.aTime < o.aTime) {
			return -1;
		} else {
			if (this.changgu > o.changgu) {
				return 1;
			} else if (this.changgu < o.changgu) {
				return -1;
			} else
				return 0;
		}
	}
}

public class SWEA_2477_차량정비소 {

	static int n, m, k, anum, bnum, result;
	static int a[], b[];
	static boolean ach[], bch[];
	static Queue<car> q1 = new LinkedList<>();
	static PriorityQueue<car> q2 = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		int count = 0;
		while (count < num) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			anum = Integer.parseInt(st.nextToken());
			bnum = Integer.parseInt(st.nextToken());

			a = new int[n + 1];
			b = new int[m + 1];
			ach = new boolean[n + 1];
			bch = new boolean[m + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= k; i++) {
				int temp = Integer.parseInt(st.nextToken());
				q1.add(new car(i, temp, 0));
			}
			result = 0;
			repair();
			if (result == 0) {
				result = -1;
			}
			bw.write("#" + (count + 1) + " " + result + "\n");
			count++;
			q1.clear();
			q2.clear();
		}

		br.close();
		bw.flush();
		bw.close();
	}

	static int check(boolean ch[], int x) {
		for (int i = 1; i <= x; i++) {
			if (!ch[i])
				return i;
		}
		return -1;
	}

	static void repair() {
		int time = 0;
		int atime[] = new int[n + 1];
		while (!q1.isEmpty()) {
			int count = 0;
			while (count < n && !q1.isEmpty()) {
				for (int i = 1; i <= n; i++) {
					if (atime[i] <= time && atime[i] > 0) {
						atime[i] = 0;
						ach[i] = false;
					}
				}
				int ch = check(ach, n);
				car now = q1.peek();

				if (ch > -1 && now.aTime <= time) {
					now = q1.poll();
					ach[ch] = true;
					atime[ch] = time + a[ch];
					q2.add(new car(now.cnum, atime[ch], ch));
				}
				count++;
			}
			count = 0;
			time++;
		}
		time = q2.peek().aTime;

		int btime[] = new int[m + 1];
		while (!q2.isEmpty()) {
			int count = 0;
			while (count < m && !q2.isEmpty()) {
				for (int i = 1; i <= m; i++) {
					if (btime[i] <= time && btime[i] > 0) {
						btime[i] = 0;
						bch[i] = false;
					}
				}
				int ch = check(bch, m);
				car now = q2.peek();
				if (ch > -1 && now.aTime <= time) {
					now = q2.poll();
					bch[ch] = true;
					btime[ch] = time + b[ch];
					if (now.changgu == anum && ch == bnum) {
						result += now.cnum;
					}
				}
				count++;
			}
			count = 0;
			time++;
		}
	}
}
