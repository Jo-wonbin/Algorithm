package BOJ_Practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			al.add(x);
		}

		for (int i = 1; i <= num; i++) {
			q.add(i);
		}

		int cnt = 0;
		while (true) {
			if (q.peekFirst() == al.get(0)) {
				al.remove(0);
				q.removeFirst();
				n--;
				if (n == 0) {
					bw.write(cnt + "");
					break;
				}
			} else {

				boolean type = false;
				int count = 0;
				int a = al.get(0);
				int c = q.size();
				for (int i = 0; i < c; i++) {
					if (q.get(i) == a) {
						if (i >= (c - i)) {
							count = c - i;
							type = false;
						} else {
							count = i;
							type = true;
						}
						break;
					}
				}

				if (type) {// ¿ÞÂÊ
					for (int i = 0; i < count; i++) {
						int tp = q.pollFirst();
						q.addLast(tp);
					}
					cnt += count;
				} else {// ¿À¸¥ÂÊ
					for (int i = 0; i < count; i++) {
						int tp = q.pollLast();
						q.addFirst(tp);
					}
					cnt += count;
				}
			}

		}
		br.close();
		bw.flush();
		bw.close();
	}

}
