package BOJ.BOJweek4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location {
	int x;
	int y;
	int z;

	location(int a, int b, int c) {
		this.x = a;
		this.y = b;
		this.z = c;
	}
}

public class BOJ_2251 {

	static Queue<location> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int a, b, c;
	static ArrayList<Integer> al = new ArrayList<>();
	static boolean check[][][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		check = new boolean[a + 1][b + 1][c + 1];
		q.offer(new location(0, 0, c));
		bfs();

		Collections.sort(al);
		for (int y : al)
			bw.write(y + " ");

		br.close();
		bw.flush();
		bw.close();
	}

	static void bfs() {

		while (!q.isEmpty()) {

			location now = q.poll();
			if (check[now.x][now.y][now.z]) { // �ߺ��̸� ���
				continue;
			}

			if (!al.contains(now.z) && now.x == 0) { // �迭�� �̹� ���յ� ���� �ƴϸ� �迭�� �� ����
				al.add(now.z);
			}

			check[now.x][now.y][now.z] = true;

			if (now.x + now.z <= a) { // C -> A
				q.add(new location(now.x + now.z, now.y, 0));
			} else {
				q.add(new location(a, now.y, now.x + now.z - a));
			}

			if (now.y + now.z <= b) { // C -> B
				q.add(new location(now.x, now.y + now.z, 0));
			} else {
				q.add(new location(now.x, b, now.y + now.z - b));
			}

			if (now.x + now.y <= b) { // A -> B
				q.add(new location(0, now.x + now.y, now.z));
			} else {
				q.add(new location(now.x + now.y - b, b, now.z));
			}

			if (now.x + now.z <= c) { // A -> C
				q.add(new location(0, now.y, now.x + now.z));
			} else {
				q.add(new location(now.x + now.z - c, now.y, c));
			}

			if (now.x + now.y <= a) { // B -> A
				q.add(new location(now.x + now.y, 0, now.z));
			} else {
				q.add(new location(a, now.x + now.y - a, now.z));
			}

			if (now.y + now.z <= c) { // B -> C
				q.add(new location(now.x, 0, now.y + now.z));
			} else {
				q.add(new location(now.x, now.x + now.y - c, c));
			}

		}
	}
}
