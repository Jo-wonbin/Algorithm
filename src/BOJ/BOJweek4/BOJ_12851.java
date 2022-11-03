package BOJ.BOJweek4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class w {
	int x, cnt;

	w(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
		;
	}
}

public class BOJ_12851 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, k, cnt = 1;
	static int result = 988898;
	static boolean check[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		check = new boolean[100001];

		bfs();

		bw.write(result + "\n"); // �ᱹ �� ��ġ�� ���� ���� ������ Ƚ���� ���
		bw.write(cnt + "");
		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() { // �ϴ� ť�� �� ����ְ� �� ���� �ش��ϴ� +1, -1, x2 ������ ������.
		Queue<w> q = new LinkedList<>();
		q.add(new w(n, 0)); // ť�� n�� ����

		while (!q.isEmpty()) {
			w now = q.poll(); // n�� q�� ù��° �� ���� �� ť���� ����
			check[now.x] = true;
//			System.out.println("====" + now.x + "------");

			if (now.x == k) {
				if (result > now.cnt) {
					result = now.cnt;
				} else if (result == now.cnt) {
					cnt++;
				}
				continue;
			}

			if (now.x + 1 <= 100000 && !check[now.x + 1]) {
				q.add(new w(now.x + 1, now.cnt + 1));
			}

			if (now.x - 1 >= 0 && !check[now.x - 1]) {
				q.add(new w(now.x - 1, now.cnt + 1));
			}
			if (now.x * 2 <= 100000 && !check[now.x * 2]) {
				q.add(new w(now.x * 2, now.cnt + 1));
			}
		}

	}
}
