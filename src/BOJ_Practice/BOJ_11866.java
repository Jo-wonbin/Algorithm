package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= num; i++) {
			q.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		int cnt = 0;
		while (cnt >= 0) {
			if (q.isEmpty()) {
				sb.append(">");
				break;
			}

			for (int i = 1; i <= k; i++) {
				if (i == k) {
					if (cnt != 0) {
						int x = q.poll();
						sb.append(", " + x);
					} else {
						int x = q.poll();
						sb.append(x);
					}
				} else {
					int x = q.poll();
					q.add(x);
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
