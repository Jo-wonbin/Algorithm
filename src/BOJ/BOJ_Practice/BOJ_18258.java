package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18258 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		int cnt = 0;
		int last = 0;
		while (cnt < num) {
			String x;
			int y = 0;
			st = new StringTokenizer(br.readLine());
			x = st.nextToken();
			if (st.hasMoreTokens()) {
				y = Integer.parseInt(st.nextToken());
			}

			if (x.equals("push")) {
				q.add(y);
				last = y;
			} else if (x.equals("front")) {
				if (q.isEmpty())
					bw.write("-1" + "\n");
				else {
					y = q.peek();
					bw.write(y + "\n");
				}
			} else if (x.equals("back")) {
				if (q.isEmpty())
					bw.write("-1" + "\n");
				else {
					bw.write(last + "\n");
				}
			} else if (x.equals("pop")) {
				if (q.isEmpty())
					bw.write("-1" + "\n");
				else {
					y = q.poll();
					bw.write(y + "\n");
				}
			} else if (x.equals("empty")) {
				if (q.isEmpty())
					bw.write("1" + "\n");
				else
					bw.write("0" + "\n");
			} else if (x.equals("size")) {
				y = q.size();
				bw.write(y + "\n");
			}

			cnt++;
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
