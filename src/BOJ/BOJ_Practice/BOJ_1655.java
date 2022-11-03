package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class pnt1 implements Comparable<pnt1> {
	int x;

	pnt1(int x) {
		this.x = x;
	}

	@Override
	public int compareTo(pnt1 o) {
		// TODO Auto-generated method stub
		if (this.x > o.x) {
			return -1;
		} else if (this.x < o.x) {
			return 1;
		}
		return 0;
	}
}

class pnt2 implements Comparable<pnt2> {
	int x;

	pnt2(int x) {
		this.x = x;
	}

	@Override
	public int compareTo(pnt2 o) {
		// TODO Auto-generated method stub
		if (this.x > o.x) {
			return 1;
		} else if (this.x < o.x) {
			return -1;
		}
		return 0;
	}
}

public class BOJ_1655 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<pnt1> max = new PriorityQueue<>();
		PriorityQueue<pnt2> min = new PriorityQueue<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());

			if (max.size() == min.size()) {
				if (!min.isEmpty()) {
					pnt2 y = min.peek();
					if (x > y.x) {
						max.add(new pnt1(y.x));
						min.remove();
						min.add(new pnt2(x));
					} else {
						max.add(new pnt1(x));
					}
				} else {
					max.add(new pnt1(x));
				}
				pnt1 z = max.peek();
				sb.append(z.x + "\n");
			} else {
				if (!max.isEmpty()) {
					pnt1 y = max.peek();
					if (x < y.x) {
						min.add(new pnt2(y.x));
						max.remove();
						max.add(new pnt1(x));
					} else {
						min.add(new pnt2(x));
					}
				} else {
					min.add(new pnt2(x));
				}
				pnt1 z = max.peek();
				sb.append(z.x + "\n");
			}
		}

		bw.write(sb + "");

		br.close();
		bw.flush();
		bw.close();
	}

}
