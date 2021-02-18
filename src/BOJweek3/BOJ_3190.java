package BOJweek3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location {
	int x;
	int y;

	location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_3190 {
	static Queue<location> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, L;
	static int map[][];
	static int curl[][];
	static int dx[] = { 0, 1, 0, -1 }; // 우하좌상
	static int dy[] = { 1, 0, -1, 0 };
	static ArrayList<location> al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String a = br.readLine();
		n = Integer.parseInt(a);
		String b = br.readLine();
		m = Integer.parseInt(b);

		map = new int[n][n];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = 2;
		}

		String c = br.readLine();
		L = Integer.parseInt(c);

		curl = new int[L][2];
		for (int i = 0; i < L; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			curl[i][0] = Integer.parseInt(st1.nextToken());
			String temp = st1.nextToken();
			curl[i][1] = (temp.equals("D")) ? -1 : 1;
		}

		snake();

		br.close();
		bw.flush();
		bw.close();
	}

	static void snake() throws IOException, ArrayIndexOutOfBoundsException {
		q.add(new location(0, 0));
		map[0][0] = 1;
		al.add(new location(0, 0));

		int tcnt = 0;
		int count = 0;
		int cnt = 0;
		int time = 0;
		
		while (true) {
			location now = q.poll();
			time += 1;

			int nx = now.x + dx[tcnt];
			int ny = now.y + dy[tcnt];

			if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1 || map[nx][ny] == 1) {
				bw.write(time + "\n");
				break;
			}

			if (map[nx][ny] == 2) {
				map[nx][ny] = 1;
				cnt += 1;
				q.add(new location(nx, ny));
				al.add(new location(nx, ny));
			} else {
				q.add(new location(nx, ny));
				map[nx][ny] = 1;
				map[now.x][now.y] = 1;
				al.add(new location(nx, ny));
			}


			while (al.size() - 1 > cnt) {
				location tail = al.get(0);
				map[tail.x][tail.y] = 0;
				al.remove(0);
			}

			if (count < L && curl[count][0] == time) {
				if (curl[count][1] == -1 && tcnt % 2 == 1) { // tcnt가 홀수일 때 오른쪽방향이면
					if (tcnt == 1) { //
						tcnt = 2;
					} else if (tcnt == 3) {
						tcnt = 0;
					}
				} else if (curl[count][1] == 1 && tcnt % 2 == 1) {
					if (tcnt == 1) { //
						tcnt = 0;
					} else if (tcnt == 3) {
						tcnt = 2;
					}
				} else if (curl[count][1] == -1 && tcnt % 2 == 0) {
					if (tcnt == 2) { //
						tcnt = 3;
					} else if (tcnt == 0) {
						tcnt = 1;
					}
				} else if (curl[count][1] == 1 && tcnt % 2 == 0) {
					if (tcnt == 2) { //
						tcnt = 1;
					} else if (tcnt == 0) {
						tcnt = 3;
					}
				}
				count += 1;
			}

		}

	}
}
