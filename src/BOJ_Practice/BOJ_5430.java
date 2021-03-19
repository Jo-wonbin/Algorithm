package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());

		int cnt = 0;
		while (cnt < num) {

			Deque<Integer> q = new ArrayDeque<Integer>();
			st = new StringTokenizer(br.readLine());

			String x = st.nextToken();
			String list[] = new String[x.length()];
			for (int i = 0; i < x.length(); i++) {
				list[i] = x.substring(i, i + 1);
			}

			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), "[|,|]");
			for (int i = 0; i < y; i++) {
				q.addLast(Integer.parseInt(st.nextToken()));
			}

			int count = 0;
			boolean error = false;
			boolean dir = true;
			while (count < list.length) {
				if (list[count].equals("R")) {// r
					if (dir) {
						dir = false;
					} else {
						dir = true;
					}
				} else {// d
					if (!q.isEmpty() && dir) {
						q.removeFirst();
					} else if (!q.isEmpty() && !dir) {
						q.removeLast();
					} else {
						error = true;
						break;
					}
				}
				count++;
			}

			if (error) {
				sb.append("error" + "\n");
			} else if (dir && !q.isEmpty()) {
				sb.append("[");
				int c = q.size();
				for (int i = 0; i < c; i++) {
					if (c == 1) {
						sb.append(q.pollFirst() + "]\n");
					} else if (i == 0) {
						sb.append(q.pollFirst());
					} else if (i != c - 1) {
						sb.append("," + q.pollFirst());
					} else {
						sb.append("," + q.pollFirst() + "]\n");
					}
				}
			} else if (!dir && !q.isEmpty()) {
				sb.append("[");
				int c = q.size();
				for (int i = 0; i < c; i++) {
					if (c == 1) {
						sb.append(q.pollLast() + "]\n");
					} else if (i == 0) {
						sb.append(q.pollLast());
					} else if (i != c - 1) {
						sb.append("," + q.pollLast());
					} else {
						sb.append("," + q.pollLast() + "]\n");
					}
				}
			} else {
				if (q.isEmpty()) {
					sb.append("[]\n");
				}
			}

			cnt++;
			q.clear();
		}
		bw.write(sb + "");

		br.close();
		bw.flush();
		bw.close();
	}

}
