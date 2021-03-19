package BOJ_Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_10866 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		int cnt = 0;
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		while (cnt < num) {

			st = new StringTokenizer(br.readLine(), " ");
			String x = st.nextToken();

			int y = 0;
			if (st.hasMoreTokens()) {
				y = Integer.parseInt(st.nextToken());
			}

			if (x.equals("push_front")) {
				q.offerFirst(y);
			} else if (x.equals("push_back")) {
				q.offerLast(y);
			} else if (x.equals("pop_front")) {
				if (q.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					y = q.pollFirst();
					sb.append(y + "\n");
				}
			} else if (x.equals("pop_back")) {
				if (q.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					y = q.pollLast();
					sb.append(y + "\n");
				}
			} else if (x.equals("size")) {
				sb.append(q.size() + "\n");
			} else if (x.equals("empty")) {
				if (q.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (x.equals("front")) {
				if (q.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					y = q.peekFirst();
					sb.append(y + "\n");
				}
			} else if (x.equals("back")) {
				if (q.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					y = q.peekLast();
					sb.append(y + "\n");
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
