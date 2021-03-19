package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class ar implements Comparable<ar> {
	long x;

	ar(long x) {
		this.x = x;
	}

	@Override
	public int compareTo(ar o) {
		// TODO Auto-generated method stub
		if(this.x > o.x) {
			return 1;
		}else if(this.x < o.x) {
			return -1;
		}
		return 0;
	}
}

public class BOJ_1927 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		long num = Long.parseLong(st.nextToken());

		PriorityQueue<ar> q = new PriorityQueue<>();

		int cnt = 0;
		while (cnt < num) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());

			if (x > 0) {
				q.add(new ar(x));
			} else {
				if (q.isEmpty()) {
					sb.append("0\n");
				} else {
					ar y = q.poll();
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
