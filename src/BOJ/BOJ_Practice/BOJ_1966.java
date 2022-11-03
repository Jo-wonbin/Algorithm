package BOJ.BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class w {
	int num;
	int x;

	w(int num, int x) {
		this.num = num;
		this.x = x;
	}
}

public class BOJ_1966 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		int cnt = 0;
		while (cnt < num) {
			ArrayList<w> q = new ArrayList<>();
			int x = 0;
			int y = 0;

			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < x; i++) {
				int z = Integer.parseInt(st.nextToken());
				q.add(new w(i, z));
			}

			int count = 0;
			while (!q.isEmpty()) {
				w a = q.get(0);
				q.remove(0);
				boolean max = true;

				for (int i = 0; i < q.size(); i++) {
					if (a.x < q.get(i).x) {
						q.add(new w(a.num, a.x));
						for (int j = 0; j < i; j++) {
							q.add(q.get(0));
							q.remove(0);
						}

						max = false;
						break;
					}
				}
				if (!max) {
					continue;
				}

				count++;
				if (a.num == y) {
					sb.append(count + "\n");
					break;
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