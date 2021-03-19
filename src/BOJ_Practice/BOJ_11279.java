package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class ra implements Comparable<ra> {
	long x;

	ra(long x) {
		this.x = x;
	}

	@Override
	public int compareTo(ra o) {
		// TODO Auto-generated method stub
		if(this.x > o.x) {
			return -1;
		}else if(this.x < o.x) {
			return 1;
		}
		return 0;
	}
}

public class BOJ_11279 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		long num = Long.parseLong(st.nextToken());

		PriorityQueue<ra> q = new PriorityQueue<>();

		int cnt = 0;
		while (cnt < num) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());

			if (x > 0) {
				q.add(new ra(x));
			} else {
				if (q.isEmpty()) {
					sb.append("0\n");
				} else {
					ra y = q.poll();
					sb.append(y.x + "\n");
				}
			}
			cnt++;
		}

		bw.write(sb + "");

		br.close();
		bw.flush();
		bw.close();
	}

}
